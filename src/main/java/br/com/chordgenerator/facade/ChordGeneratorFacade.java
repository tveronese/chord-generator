package br.com.chordgenerator.facade;

import br.com.chordgenerator.generator.GeneratorService;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class ChordGeneratorFacade {

	/**
	 * Generate positional notation for the input chord.
	 * 
	 * @param chord The chord to generate the notation.
	 * @return The positional notation.
	 * @throws ChordGenerationException If an error happened while generating the chord.
	 */
	public static PositionalNotation generateChordPositionalNotation(Instrument instrument, String chord)
			throws ChordGenerationException {

		return GeneratorService.getPositionalNotation(instrument, chord);
	}

}
