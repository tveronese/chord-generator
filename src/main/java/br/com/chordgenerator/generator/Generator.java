package br.com.chordgenerator.generator;

import java.util.regex.Pattern;

import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;

public class Generator {

	private static final Integer tone = 2;

	private static final Integer semitone = 1;

	public FFSNotation getFFSNotation(Instrument instrument, String sChord) {

		if (!validateChord(sChord)) {
			return null;
		}

		Chord chord = generateChord(Note.valueOf(sChord));
		FFSNotation ffs = instrument.generatePositionalNotation(chord);
		return ffs;
	}

	private boolean validateChord(String chord) {

		return Pattern.matches("[A-G]", chord);
	}

	private Chord generateChord(Note note) {

		// TODO Currently only generates major chords, improve to generate minor ones

		Note secondNote = note.getRespectiveNote(2 * tone);
		Note thirdNote = secondNote.getRespectiveNote(tone + semitone);
		return new Chord(note, secondNote, thirdNote);
	}

}
