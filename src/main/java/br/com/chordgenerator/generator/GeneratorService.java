package br.com.chordgenerator.generator;

import static java.lang.String.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.chords.MinorChord;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class GeneratorService {

	private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G])(m)?");

	private static final String MINOR_CHORD_MODIFIER = "m";

	private static Chord generateChord(String chordString) throws ChordGenerationException {

		Matcher matcher = NOTE_PATTERN.matcher(chordString);
		if (!matcher.matches()) {
			throw new ChordGenerationException(format("No chord generator implemented for: %s.", chordString));
		}

		Note firstNote = Note.valueOf(matcher.group(1));
		String modifiers = matcher.group(2);

		if (modifiers == null) {
			return new MajorChord(firstNote);
		}

		if (modifiers.equals(MINOR_CHORD_MODIFIER)) {
			return new MinorChord(firstNote);
		}

		throw new ChordGenerationException(
				format("Chord generator NYI for: Note = %s; Modifiers = %s.", firstNote.name(), modifiers));
	}

	public static PositionalNotation getPositionalNotation(Instrument instrument, String chordString)
			throws ChordGenerationException {

		Chord chord = generateChord(chordString);
		return instrument.generatePositionalNotation(chord);
	}

	public static void getPositionalNotationImage(Instrument instrument, String chordString)
			throws ChordGenerationException {

		PositionalNotation pn = getPositionalNotation(instrument, chordString);
		instrument.generatePositionalNotationImage(pn);
	}

}
