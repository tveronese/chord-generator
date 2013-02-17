package br.com.chordgenerator.generator;

import java.util.regex.Pattern;

import br.com.chordgenerator.generator.notation.FFSNotation;

public class Generator {

	public FFSNotation getFFSNotation(String sChord) {

		if (!validateChord(sChord)) {
			return null;
		}

		Chord chord = generateChord(Note.valueOf(sChord));
		System.out.println(chord);

		return null;
	}

	private boolean validateChord(String chord) {

		return Pattern.matches("[A-G]", chord);
	}

	private Chord generateChord(Note note) {

		// TODO Currently only generates major chords, improve to generate minor ones

		Note secondNote = note.getRespectiveNote(4);
		Note thirdNote = secondNote.getRespectiveNote(3);
		return new Chord(note, secondNote, thirdNote);
	}

	public static void main(String[] args) {

		new Generator().getFFSNotation("D");
	}

}
