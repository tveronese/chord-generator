package br.com.chordgenerator.commands;

import java.util.Arrays;

import br.com.chordgenerator.facade.ChordGeneratorFacade;
import br.com.chordgenerator.logger.Logger;

public class GenerateNotationCommand extends Command {

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
	public void execute(ChordGeneratorFacade facade) {

		Logger.debug(this, "Generating chord notation.");
		System.out.println(Arrays.toString(getArguments()));

		// TODO Auto-generated method stub
	}

}
