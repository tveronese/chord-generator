package br.com.chordgenerator.generator.instruments;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public interface Instrument {

	String getType();

	PositionalNotation generatePositionalNotation(Chord chord);

}
