package br.com.chordgenerator.commands;

import br.com.chordgenerator.generator.instruments.InstrumentType;
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
	public void execute(Configuration configuration) {

		Logger.debug(this, "Specifying instrument...");
		String typeName = getArguments()[0];
		InstrumentType type = InstrumentType.valueOf(typeName);
		configuration.setType(type);
		Logger.debug(this, "Specified %s as instrument type.", type.name());
	}
}
