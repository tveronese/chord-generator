package br.com.chordgenerator.generator;

import java.util.Set;
import java.util.TreeSet;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.Note;
import br.com.chordgenerator.generator.instruments.KeyInstrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.nk.KeyNumberAndNote;
import br.com.chordgenerator.generator.notation.nk.NumberedKeysNotation;

public class KeyInstrumentChordGenerator extends ChordGenerator<KeyInstrument> {

    public KeyInstrumentChordGenerator(KeyInstrument keyInstrument) {

        super(keyInstrument);
    }

    @Override
    protected Set<PositionalNotation> generateAllPositionalNotations(Chord chord) {

        Note firstNote = Note.C;
        NumberedKeysNotation notation = new NumberedKeysNotation(chord);

        Note root = chord.getRoot();
        int rootOffset = firstNote.getSemitonesOffset(root);
        notation.getKeys().add(new KeyNumberAndNote(rootOffset, root));

        for (Note note : chord.getNotes()) {

            if (note == root) {
                continue;
            }

            int noteOffset = root.getSemitonesOffset(note);
            notation.getKeys().add(new KeyNumberAndNote(rootOffset + noteOffset, note));
        }

        Set<PositionalNotation> notations = new TreeSet<PositionalNotation>();
        notations.add(notation);
        return notations;
    }

}
