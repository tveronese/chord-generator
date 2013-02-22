package br.com.chordgenerator.generator.chords;

import br.com.chordgenerator.generator.Note;

public class MajorChord extends Chord {

	public MajorChord(Note firstNote) {

		super();

		Note secondNote = firstNote.getRespectiveNote(2 * tone);
		Note thirdNote = secondNote.getRespectiveNote(tone + semitone);

		this.getNotes().add(firstNote);
		this.getNotes().add(secondNote);
		this.getNotes().add(thirdNote);
	}

}
