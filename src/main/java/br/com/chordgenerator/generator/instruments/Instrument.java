package br.com.chordgenerator.generator.instruments;

public abstract class Instrument {

    public static final Integer HUMAN_MAXIMUM_FINGERS = 4;

    private InstrumentType type;

    public Instrument(InstrumentType type) {

        this.type = type;
    }

    public InstrumentType getType() {

        return type;
    }

}
