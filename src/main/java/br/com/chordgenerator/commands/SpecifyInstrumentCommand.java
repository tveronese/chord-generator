package br.com.chordgenerator.commands;

import java.util.Arrays;

import br.com.chordgenerator.logger.Logger;

public class SpecifyInstrumentCommand extends Command {

	@Override
	public String getArgument() {

		return "i";
	}

	@Override
	public String getHelpString() {

		return "-i <instrument>	Specify the instrument to generate the chord notation.";
	}

	@Override
	public int getNumberOfArgs() {

		return 1;
	}

	@Override
	public void execute() {

		Logger.debug(this, "Specifying instrument.");
		System.out.println(Arrays.toString(getArguments()));

		// TODO Auto-generated method stub
	}

}
