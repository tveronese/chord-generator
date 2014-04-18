package br.com.chordgenerator.service;

import java.util.Set;

import br.com.chordgenerator.generator.ChordGenerator;
import br.com.chordgenerator.generator.GeneratorFactory;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.InstrumentType;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public final class GeneratorService {

    private GeneratorService() {

        throw new AssertionError();
    }

    public static Set<PositionalNotation> getPositionalNotations(InstrumentType type, String chordString)
            throws ChordGenerationException {

        ChordGenerator<?> generator = GeneratorFactory.createGenerator(type);

        return generator.generateAllPositionalNotations(chordString);
    }
}
