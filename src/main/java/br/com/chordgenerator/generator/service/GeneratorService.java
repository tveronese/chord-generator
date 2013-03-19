package br.com.chordgenerator.generator.service;

import static java.lang.String.format;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.chords.MinorChord;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class GeneratorService {

	private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G]#?)(m?)");

	private static final String MINOR_CHORD_MODIFIER = "m";

	public static Set<PositionalNotation> getPositionalNotations(Instrument instrument, String chordString)
			throws ChordGenerationException {

		Chord chord = generateChord(chordString);
		return generateAllPositionalNotations(instrument, chord);
	}

	private static Chord generateChord(String chordString) throws ChordGenerationException {

		Matcher matcher = NOTE_PATTERN.matcher(chordString);
		if (!matcher.matches()) {
			throw new ChordGenerationException(format("No chord generator implemented for: %s.", chordString));
		}

		Note root = Note.getNoteFromRepresentation(matcher.group(1));
		String modifiers = matcher.group(2);

		if (modifiers == null || modifiers.isEmpty()) {
			return new MajorChord(root);
		}

		if (modifiers.equals(MINOR_CHORD_MODIFIER)) {
			return new MinorChord(root);
		}

		throw new ChordGenerationException(
				format("Chord generator NYI for: Note = %s; Modifiers = %s.", root.name(), modifiers));
	}

	private static Set<PositionalNotation> generateAllPositionalNotations(Instrument instrument, Chord chord) {

		return instrument.generateAllPositionalNotation(chord);
	}

}
