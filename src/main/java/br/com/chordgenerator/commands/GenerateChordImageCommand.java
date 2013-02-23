package br.com.chordgenerator.commands;

import br.com.chordgenerator.facade.ChordGeneratorFacade;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.StringInstrument;
import br.com.chordgenerator.logger.Logger;

public class GenerateChordImageCommand extends Command {

	@Override
	public String getArgument() {

		return "ci";
	}

	@Override
	public String getHelpString() {

		return "-ci <chord>	Generate the positional notation image for the specified chord.";
	}

	@Override
	public int getNumberOfArgs() {

		return 1;
	}

	@Override
	public void execute() {

		String chord = getArguments()[0];

		Logger.debug(this, "Generating chord \"%s\" positional notation image.", chord);

		try {
			ChordGeneratorFacade.generateChordPositionalNotationImage(new StringInstrument(), chord);
			System.out.format("Generated positional notation image for chord \"%s\":\n", chord);
		}
		catch (ChordGenerationException e) {
			System.out.println(e.getMessage());
			Logger.error(this, e, "Error generating chord image.");
		}

		Logger.debug(this, "Chord notation image generation ended.");
	}

}
