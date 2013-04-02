package br.com.chordgenerator.generator.chords;

import br.com.chordgenerator.generator.Note;

public class MajorChord extends Chord {

	public MajorChord(Note root) {

		// 1-3-5
		super(root, 2 * TONE, TONE + SEMITONE);
	}

}
