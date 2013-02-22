package br.com.chordgenerator.generator;

import static java.lang.String.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.chords.MinorChord;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.logger.Logger;

public class Generator {

	private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G])(m)?");

	private static final String MINOR_CHORD_MODIFIER = "m";

	public static FFSNotation getFFSNotation(Instrument instrument, String noteString) {

		Matcher matcher = NOTE_PATTERN.matcher(noteString);
		if (!matcher.matches()) {
			return null;
		}

		Note note = Note.valueOf(matcher.group(1));
		String modifiers = matcher.group(2);

		Chord chord = generateChord(note, modifiers);
		FFSNotation ffs = instrument.generatePositionalNotation(chord);

		return ffs;
	}

	private static Chord generateChord(Note firstNote, String modifiers) {

		if (modifiers == null) {

			return new MajorChord(firstNote);
		}

		if (modifiers.equals(MINOR_CHORD_MODIFIER)) {
			return new MinorChord(firstNote);
		}

		String msg = format("No chord generator implemented for: Note = %s; Modifiers = %s.", firstNote.name(), modifiers);
		IllegalStateException e = new IllegalStateException(msg);
		Logger.error(Generator.class, e, msg);
		throw e;
	}

}
