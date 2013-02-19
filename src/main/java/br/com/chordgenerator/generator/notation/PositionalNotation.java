package br.com.chordgenerator.generator.notation;

import br.com.chordgenerator.generator.Chord;

public abstract class PositionalNotation {

	private Chord chord;

	public PositionalNotation(Chord chord) {

		this.chord = chord;
	}

	public Chord getChord() {

		return chord;
	}

	public void setChord(Chord chord) {

		this.chord = chord;
	}

}
