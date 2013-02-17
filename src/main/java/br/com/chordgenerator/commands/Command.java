package br.com.chordgenerator.commands;

import br.com.chordgenerator.facade.ChordGeneratorFacade;

public abstract class Command {

	private String[] arguments;

	public abstract String getArgument();

	public abstract String getHelpString();

	public abstract int getNumberOfArgs();

	public abstract void execute(ChordGeneratorFacade facade);

	public String[] getArguments() {

		return arguments;
	}

	public void setArguments(String[] arguments) {

		this.arguments = arguments;
	}

}
