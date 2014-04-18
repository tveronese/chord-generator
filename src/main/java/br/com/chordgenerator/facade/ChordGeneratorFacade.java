package br.com.chordgenerator.facade;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.InstrumentType;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.service.GeneratorService;

import com.google.common.base.Strings;

public final class ChordGeneratorFacade {

    private ChordGeneratorFacade() {

        throw new AssertionError();
    }

    /**
     * Generate positional notation for the type of instrument and chord.
     * 
     * @param type The desired type of instrument.
     * @param chord The chord to generate the positioning.
     * @return The positional notation.
     * @throws ChordGenerationException If an error happened while generating the chord.
     */
    public static List<PositionalNotation> generateChordPositionalNotations(InstrumentType type, String chord)
            throws ChordGenerationException {

        checkNotNull(type, "Instrument type cannot be null.");
        checkNotNull(!Strings.isNullOrEmpty(chord), "Chord cannot be null or empty.");

        Set<PositionalNotation> pns = GeneratorService.getPositionalNotations(type, chord);
        return new ArrayList<PositionalNotation>(pns);
    }

}
