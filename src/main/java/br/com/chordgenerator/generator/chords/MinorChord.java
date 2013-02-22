package br.com.chordgenerator.generator.chords;

import br.com.chordgenerator.generator.Note;

public class MinorChord extends Chord {

	public MinorChord(Note firstNote) {

		super();

		Note secondNote = firstNote.getRespectiveNote(tone + semitone);
		Note thirdNote = secondNote.getRespectiveNote(2 * tone);

		this.getNotes().add(firstNote);
		this.getNotes().add(secondNote);
		this.getNotes().add(thirdNote);
	}

}
