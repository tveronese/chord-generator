package br.com.chordgenerator.generator;

import static java.lang.String.format;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.InstrumentType;
import br.com.chordgenerator.generator.instruments.KeyInstrument;
import br.com.chordgenerator.generator.instruments.StringInstrument;

import com.google.common.base.Preconditions;

public final class GeneratorFactory {

    private GeneratorFactory() {

        throw new AssertionError();
    }

    public static ChordGenerator<?> createGenerator(InstrumentType instrument) throws ChordGenerationException {

        Preconditions.checkArgument(instrument != null, "Instrument cannot be null.");

        switch (instrument) {
            case PIANO:
                return new KeyInstrumentChordGenerator(new KeyInstrument());
            case SIX_STRINGS_GUITAR:
                return new StringInstrumentChordGenerator(new StringInstrument());
        }

        throw new ChordGenerationException(format("Chord generator NYI for: Instrument = %s.", instrument.toString()));
    }
}
