package br.com.chordgenerator.generator.instruments;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.generator.notation.ffs.Finger;
import br.com.chordgenerator.generator.notation.ffs.FingerFretString;

public class AcousticGuitar implements Instrument {

	private List<Note> strings;

	public AcousticGuitar() {

		this.strings = new ArrayList<Note>();

		this.strings.add(Note.E);
		this.strings.add(Note.B);
		this.strings.add(Note.G);
		this.strings.add(Note.D);
		this.strings.add(Note.A);
		this.strings.add(Note.E);
	}

	@Override
	public String getType() {

		// TODO use an Enum...
		return "string";
	}

	@Override
	public FFSNotation generatePositionalNotation(Chord chord) {

		List<FingerFretString> positions = new ArrayList<FingerFretString>();

		for (int string = 0; string < this.strings.size(); string++) {

			Integer fret = getFretWithNote(string, chord.getNotes());

			if (fret != 0) {

				FingerFretString ffs = new FingerFretString();
				ffs.setFret(fret);
				ffs.setString(string);
				// TODO implement finger attribution algorithm
				ffs.setFinger(Finger.ONE);

				positions.add(ffs);
			}
		}

		FFSNotation ffsn = new FFSNotation(chord);
		ffsn.setPositions(positions);
		return ffsn;
	}

	private Integer getFretWithNote(Integer stringNumber, List<Note> notes) {

		Note currentNote = this.strings.get(stringNumber);
		Integer fret = 0;

		while (!notes.contains(currentNote)) {

			currentNote = currentNote.getRespectiveNote(1);
			fret++;
		}

		return fret;
	}

}
