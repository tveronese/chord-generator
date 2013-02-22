package br.com.chordgenerator.generator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.chords.MinorChord;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;

public class Generator {

	private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G])(m)?");

	private static final String MINOR_CHORD_MODIFIER = "m";

	public FFSNotation getFFSNotation(Instrument instrument, String noteString) {

		Matcher matcher = NOTE_PATTERN.matcher(noteString);
		if (!matcher.matches()) {
			return null;
		}

		Note note = Note.valueOf(matcher.group(1));
		String modifiers = matcher.group(2);

		Chord chord = this.generateChord(note, modifiers);
		FFSNotation ffs = instrument.generatePositionalNotation(chord);

		return ffs;
	}

	private Chord generateChord(Note firstNote, String modifiers) {

		Chord chord;
		if (modifiers.equals(MINOR_CHORD_MODIFIER)) {

			chord = new MinorChord(firstNote);
		}
		else {

			chord = new MajorChord(firstNote);
		}

		return chord;
	}

}
