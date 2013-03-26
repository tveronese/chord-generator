package br.com.chordgenerator.generator.chords;

import br.com.chordgenerator.generator.Note;

public class MinorChord extends Chord {

	public MinorChord(Note root) {

		// 1-b3-5
		super(root, tone + semitone, 2 * tone);
	}

}
