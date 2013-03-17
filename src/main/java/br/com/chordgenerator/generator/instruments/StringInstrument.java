package br.com.chordgenerator.generator.instruments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffp.FFSNotation;
import br.com.chordgenerator.generator.notation.ffp.FingerFretPosition;
import br.com.chordgenerator.generator.notation.ffp.FingerFretString;

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
	public PositionalNotation generatePositionalNotation(Chord chord) {

		// First find FFSs for tonic note
		int initialFret = 0;
		Note root = chord.getRoot();
		int lastString = this.pitches.size() - 1;
		List<FingerFretString> tonicNoteFFSs = searchFFSForNote(root, lastString, initialFret, initialFret + 4);
		if (tonicNoteFFSs.isEmpty()) {
			// TODO treat
			return null;
		}

		// TODO change to generate all positions (currently generating only for the first
		FingerFretString tonicFFS = tonicNoteFFSs.get(0);
		Set<FingerFretPosition> positions = new TreeSet<FingerFretPosition>();
		positions.add(tonicFFS);

		int firstString = tonicFFS.getString() - 1;
		List<Note> chordNotes = chord.getNotes();
		if (firstString < chordNotes.size() - 1) {
			// In fact, should remove tonicFFS from possible FFS
			return null;
		}

		// Define current and last fret (to be changed when iterating over all frets)
		int currentFirstFret = tonicFFS.getFret() - 4;
		currentFirstFret = currentFirstFret < 0 ? 0 : currentFirstFret;
		int currentLastFret = currentFirstFret + 4;
		List<FingerFretString> ffsList = searchFFSForNotes(chordNotes, firstString, currentFirstFret, currentLastFret);
		positions.addAll(ffsList);

		FFSNotation ffsn = new FFSNotation(chord);
		ffsn.setPositions(positions);
		return ffsn;
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
			if (ffs != null) {
				ffsList.add(ffs);
			}
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
			}
		}

		return ffs;
	}

}
