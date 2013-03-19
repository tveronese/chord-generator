package br.com.chordgenerator.generator.instruments;

import java.util.Set;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public interface Instrument {

	Set<PositionalNotation> generateAllPositionalNotation(Chord chord);

}
