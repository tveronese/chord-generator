package br.com.chordgenerator.facade;

import br.com.chordgenerator.generator.Generator;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;

public class ChordGeneratorFacade {

	/**
	 * Generate positional notation for the input chord.
	 * 
	 * @param chord The chord to generate the notation.
	 * @return The positional notation.
	 */
	public static FFSNotation generateChordPositionalNotation(Instrument instrument, String chord) {

		return Generator.getFFSNotation(instrument, chord);
	}

}
