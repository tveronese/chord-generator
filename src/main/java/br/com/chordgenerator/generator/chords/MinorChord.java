package br.com.chordgenerator.generator.chords;


public class MinorChord extends Chord {

    public MinorChord(Note root) {

        // 1-b3-5
        super(root, TONE + SEMITONE, 2 * TONE);
    }

}
