package br.com.chordgenerator.generator.instruments;

import br.com.chordgenerator.generator.Chord;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;

public interface Instrument {

	String getType();

	FFSNotation generatePositionalNotation(Chord chord);

}
