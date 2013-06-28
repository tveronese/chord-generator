package br.com.chordgenerator.commands;

public class SpecifyChordCommand extends Command {

	@Override
	public String getArgument() {

		return "c";
	}

	@Override
	public String getHelpString() {

		return "-c <chord>	Obtain notation for the specified chord.";
	}

	@Override
	public int getNumberOfArgs() {

		return 1;
	}

	@Override
	public void execute(Configuration configuration) {

		String chord = getArguments()[0];
		configuration.setChord(chord);
	}

}
