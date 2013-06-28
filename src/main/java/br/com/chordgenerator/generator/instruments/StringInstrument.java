package br.com.chordgenerator.generator.instruments;

import java.util.*;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffp.*;
import br.com.chordgenerator.logger.Logger;

public class StringInstrument extends Instrument {

	private static final Integer HUMAN_MAXIMUM_FINGERS = 4;

	private List<Note> pitches;

	/**
	 * Private constructor to define the correct type of instrument.
	 * 
	 * @param type Only KEY instrument type.
	 */
	private StringInstrument(InstrumentType type) {

		super(type);
	}

	public StringInstrument() {

		this(InstrumentType.SIX_STRINGS_GUITAR);
		this.pitches = Arrays.asList(Note.E, Note.B, Note.G, Note.D, Note.A, Note.E);
	}

	public StringInstrument(List<Note> pitches) {

		this();
		this.pitches = pitches;
	}

	@Override
	public Set<PositionalNotation> generateAllPositionalNotations(Chord chord) {

		List<FingerFretString> tonicNoteFFSs = findTonicFFS(chord);
		Set<FFSNotation> possibleFFS = findPossibleFFS(chord, tonicNoteFFSs);
		possibleFFS = findAndConvertBarreChords(possibleFFS);

		return new TreeSet<PositionalNotation>(possibleFFS);
	}

	private Set<FFSNotation> findPossibleFFS(Chord chord, List<FingerFretString> tonicNoteFFSs) {

		SortedSet<FFSNotation> possibleFFS = new TreeSet<FFSNotation>();
		for (FingerFretString tonicFFS : tonicNoteFFSs) {

			if (tonicFFS.getString() < chord.getNotes().size()) {
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

	private Set<FFSNotation> findRemainderForTonic(Chord chord, FingerFretString tonicFFS) {

		int firstString = tonicFFS.getString() - 1;
		Set<FFSNotation> possibleFFS = new TreeSet<FFSNotation>();
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
				ffsn.getPositions().addAll(positions);
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

	private Set<FFSNotation> findAndConvertBarreChords(Set<FFSNotation> possibleFFS) {

		Set<FFSNotation> newFFS = new TreeSet<FFSNotation>();

		for (FFSNotation ffsn : possibleFFS) {

			int fingersNeeded = ffsn.getNumberOfFingersNeeded();
			if (fingersNeeded <= HUMAN_MAXIMUM_FINGERS) {
				newFFS.add(ffsn);
				continue;
			}

			int minFret = ffsn.getMinimumFret(true);
			List<FingerFretString> barreFFPs = ffsn.getPositionsAtFret(minFret);

			if (fingersNeeded - barreFFPs.size() + 1 > HUMAN_MAXIMUM_FINGERS) {
				continue;
			}

			FingerBarreFret barre = new FingerBarreFret(1, minFret);
			barre.addReplacedPositions(barreFFPs);

			ffsn.getPositions().removeAll(barreFFPs);
			ffsn.getPositions().add(barre);

			if (checkFretSmallerThanBarre(ffsn, minFret)) {
				newFFS.add(ffsn);
			}
		}

		return newFFS;
	}

	private boolean checkFretSmallerThanBarre(FFSNotation ffsn, Integer minFret) {

		for (FingerFretPosition ffp : ffsn.getPositions()) {

			if (!(ffp instanceof FingerBarreFret) && ffp.getFret() < minFret) {
				return false;
			}
		}

		return true;
	}

}
