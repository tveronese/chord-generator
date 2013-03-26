package br.com.chordgenerator.facade;

import java.util.Set;

import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.service.GeneratorService;

public class ChordGeneratorFacade {

	/**
	 * Generate positional notation for the input chord.
	 * 
	 * @param chord The chord to generate the notation.
	 * @return The positional notation.
	 * @throws ChordGenerationException If an error happened while generating the chord.
	 */
	public static Set<PositionalNotation> generateChordPositionalNotations(Instrument instrument, String chord)
			throws ChordGenerationException {

		return GeneratorService.getPositionalNotations(instrument, chord);
	}

}
