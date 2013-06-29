package br.com.chordgenerator.generator.instruments.builder;

import br.com.chordgenerator.generator.instruments.*;

public class InstrumentBuilder {

    protected InstrumentBuilder() {

        // Hiding public constructor.
    }

    public static Instrument buildDefault(InstrumentType type) {

        switch (type) {
            case PIANO:
                return buildDefaultKeyInstrument();

            case SIX_STRINGS_GUITAR:
                return buildDefaultStringInstrument();
        }

        throw new IllegalStateException("Builder not implemented for type " + type.name());
    }

    public static StringInstrument buildDefaultStringInstrument() {

        return new StringInstrument();
    }

    public static KeyInstrument buildDefaultKeyInstrument() {

        return new KeyInstrument();
    }

}
