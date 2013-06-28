package br.com.chordgenerator.commands;

import br.com.chordgenerator.generator.instruments.InstrumentType;

public class Configuration {

	private InstrumentType type;

	private String chord;

	public InstrumentType getType() {

		return type;
	}

	public void setType(InstrumentType type) {

		this.type = type;
	}

	public String getChord() {

		return chord;
	}

	public void setChord(String chord) {

		this.chord = chord;
	}

}
