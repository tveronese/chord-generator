package br.com.chordgenerator.commands;

import br.com.chordgenerator.commands.factory.CommandFactory;
import br.com.chordgenerator.facade.ChordGeneratorFacade;

public class HelpCommand extends Command {

	@Override
	public String getArgument() {

		return "h";
	}

	@Override
	public String getHelpString() {

		return "-h		Shows this help.";
	}

	@Override
	public int getNumberOfArgs() {

		return 0;
	}

	@Override
	public void execute(ChordGeneratorFacade facade) {

		System.out.println("Chord generator help:");

		for (Command cmd : CommandFactory.getCmdsList()) {
			System.out.println(cmd.getHelpString());
		}
	}

}
