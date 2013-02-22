package br.com.chordgenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;

public class Generator {

	private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G])(m)?");

	private static final String MINOR_CHORD_MODIFIER = "m";

	private static final Integer tone = 2;

	private static final Integer semitone = 1;

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

		List<Note> notes = new ArrayList<>();
		notes.add(firstNote);

		if (modifiers.equals(MINOR_CHORD_MODIFIER)) {

			notes.add(firstNote.getRespectiveNote(tone + semitone));
			notes.add(secondNote.getRespectiveNote(2 * tone));
		}
		else {

			secondNote = firstNote.getRespectiveNote(2 * tone);
			thirdNote = secondNote.getRespectiveNote(tone + semitone);
		}

		return new Chord(notes);
	}

}
