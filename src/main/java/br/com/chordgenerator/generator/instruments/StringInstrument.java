package br.com.chordgenerator.generator.instruments;

import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.generator.chords.Note;

public class StringInstrument extends Instrument {

    private List<Note> pitches;

    public StringInstrument() {

        super(InstrumentType.SIX_STRINGS_GUITAR);
        this.pitches = Arrays.asList(Note.E, Note.B, Note.G, Note.D, Note.A, Note.E);
    }

    public StringInstrument(List<Note> pitches) {

        this();
        this.pitches = pitches;
    }

    public List<Note> getPitches() {

        return this.pitches;
    }

}
