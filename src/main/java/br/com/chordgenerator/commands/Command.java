package br.com.chordgenerator.commands;

public abstract class Command {

	private String[] arguments;

	public abstract String getArgument();

	public abstract String getHelpString();

	public abstract int getNumberOfArgs();

	public abstract void execute(Configuration configuration);

	public String[] getArguments() {

		return arguments;
	}

	public void setArguments(String[] arguments) {

		this.arguments = arguments;
	}

}
