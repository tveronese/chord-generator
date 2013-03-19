package br.com.chordgenerator.generator.instruments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffp.FFSNotation;
import br.com.chordgenerator.generator.notation.ffp.FingerFretPosition;
import br.com.chordgenerator.generator.notation.ffp.FingerFretString;
import br.com.chordgenerator.logger.Logger;

public class StringInstrument implements Instrument {

	private List<Note> pitches;

	public StringInstrument() {

		this.pitches = new ArrayList<Note>();
		this.pitches.add(Note.E);
		this.pitches.add(Note.B);
		this.pitches.add(Note.G);
		this.pitches.add(Note.D);
		this.pitches.add(Note.A);
		this.pitches.add(Note.E);
	}

	@Override
	public Set<PositionalNotation> generateAllPositionalNotation(Chord chord) {

		// First find FFSs for tonic note
		List<FingerFretString> tonicNoteFFSs = findTonicFFS(chord);

		SortedSet<PositionalNotation> possibleFFS = new TreeSet<PositionalNotation>();
		for (FingerFretString tonicFFS : tonicNoteFFSs) {

			if (tonicFFS.getString() < chord.getNotes().size() - 1) {
				// Do not add tonicFFS to possible FFS
				continue;
			}

			possibleFFS.addAll(findRemainderForTonic(chord, tonicFFS));
		}

		return possibleFFS;
	}

	private List<FingerFretString> findTonicFFS(Chord chord) {

		Note root = chord.getRoot();
		int lastString = this.pitches.size() - 1;

		int initialFret = 0;
		// Starts repeating on twelfth, so, search until 11
		int finalFret = 11;
		List<FingerFretString> ffss = searchFFSForNote(root, lastString, initialFret, finalFret);
		if (ffss.isEmpty()) {
			Logger.warn(this, "Did not found any tonic FFS for frets from %d to %d.", initialFret, finalFret);
		}

		return ffss;
	}

	private Set<PositionalNotation> findRemainderForTonic(Chord chord, FingerFretString tonicFFS) {

		int firstString = tonicFFS.getString() - 1;
		Set<PositionalNotation> possibleFFS = new TreeSet<PositionalNotation>();
		for (int fretOffset = 3; fretOffset >= 0; fretOffset--) {

			int currentFirstFret = tonicFFS.getFret() - fretOffset;
			if (currentFirstFret < 0) {
				fretOffset += currentFirstFret;
				currentFirstFret = 0;
			}
			int currentLastFret = currentFirstFret + 3;

			List<FingerFretString> ffsList = searchFFSForNotes(chord.getNotes(), firstString, currentFirstFret, currentLastFret);

			if (ffsList != null && !ffsList.isEmpty()) {
				Set<FingerFretPosition> positions = new TreeSet<FingerFretPosition>();
				positions.add(tonicFFS);
				positions.addAll(ffsList);

				FFSNotation ffsn = new FFSNotation(chord);
				ffsn.setPositions(positions);
				possibleFFS.add(ffsn);
			}
		}

		return possibleFFS;
	}

	private List<FingerFretString> searchFFSForNote(Note note, int firstString, int initialFret, int finalFret) {

		List<Note> notes = new ArrayList<Note>();
		notes.add(note);
		return searchFFSForNotes(notes, firstString, initialFret, finalFret);
	}

	private List<FingerFretString> searchFFSForNotes(List<Note> notes, int firstString, int initialFret, int finalFret) {

		// Find FFS descending from first string
		List<FingerFretString> ffsList = new ArrayList<FingerFretString>();
		for (int currentString = firstString; currentString >= 0; currentString--) {

			FingerFretString ffs = searchStringForNote(notes, currentString, initialFret, finalFret);
			if (ffs == null) {
				return null;
			}
			ffsList.add(ffs);
		}

		return ffsList;
	}

	private FingerFretString searchStringForNote(List<Note> notes, int stringNumber, int initialFret, int finalFret) {

		FingerFretString ffs = null;

		Note looseStringNote = this.pitches.get(stringNumber);
		for (int currentFret = initialFret; currentFret <= finalFret; currentFret++) {

			Note currentNote = looseStringNote.getRespectiveNote(currentFret);
			if (notes.contains(currentNote)) {

				ffs = new FingerFretString();
				ffs.setFinger(1);
				ffs.setFret(currentFret);
				ffs.setString(stringNumber);
				break;
			}
		}

		return ffs;
	}

}
