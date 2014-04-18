package br.com.chordgenerator.generator.chords;


public class MajorChord extends Chord {

    public MajorChord(Note root) {

        // 1-3-5
        super(root, 2 * TONE, TONE + SEMITONE);
    }

}
