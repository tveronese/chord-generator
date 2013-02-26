package br.com.chordgenerator.generator.instruments;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.generator.notation.ffs.FingerFretPosition;
import br.com.chordgenerator.generator.notation.ffs.FingerFretString;

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

		List<FingerFretPosition> positions = new ArrayList<FingerFretPosition>();

		for (int string = 0; string < this.pitches.size(); string++) {

			Integer fret = getFretWithNote(string, chord.getNotes());

			if (fret != 0) {

				FingerFretString ffs = new FingerFretString();
				ffs.setFret(fret);
				ffs.setString(string);
				// TODO implement finger attribution algorithm
				ffs.setFinger(1);

				positions.add(ffs);
			}
		}

		replacePositionsWithBarreIfNeeded(positions);

		FFSNotation ffsn = new FFSNotation(chord);
		ffsn.setPositions(positions);
		return ffsn;
	}

	private Integer getFretWithNote(Integer stringNumber, List<Note> notes) {

		Note currentNote = this.pitches.get(stringNumber);
		Integer fret = 0;

		while (!notes.contains(currentNote)) {

			currentNote = currentNote.getRespectiveNote(1);
			fret++;
		}

		return fret;
	}

	private void replacePositionsWithBarreIfNeeded(List<FingerFretPosition> positions) {

	}

}
