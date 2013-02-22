package br.com.chordgenerator.commands;

import br.com.chordgenerator.facade.ChordGeneratorFacade;
import br.com.chordgenerator.generator.instruments.AcousticGuitar;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.logger.Logger;

public class GenerateChordCommand extends Command {

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
	public void execute() {

		String chord = getArguments()[0];

		Logger.debug(this, "Generating chord \"%s\" positional notation.", chord);

		FFSNotation ffsn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), chord);

		System.out.format("Generated positional notation for chord \"%s\":\n", chord);
		System.out.print(ffsn);

		Logger.debug(this, "Generating chord notation.");
	}

}
