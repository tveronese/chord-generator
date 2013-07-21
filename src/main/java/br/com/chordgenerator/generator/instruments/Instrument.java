package br.com.chordgenerator.generator.instruments;

import java.util.Set;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public abstract class Instrument {

    private InstrumentType type;

    public Instrument(InstrumentType type) {

        this.type = type;
    }

    public InstrumentType getType() {

        return type;
    }

    public abstract Set<PositionalNotation> generateAllPositionalNotations(Chord chord);

}
