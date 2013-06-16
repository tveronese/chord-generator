package br.com.chordgenerator.commands;

import java.util.Set;

import br.com.chordgenerator.facade.ChordGeneratorFacade;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.KeyInstrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;
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

		try {
			Set<PositionalNotation> pns = ChordGeneratorFacade
					.generateChordPositionalNotations(new KeyInstrument(), chord);
			System.out.format("Generated positional notation for chord \"%s\":%n", chord);

			int i = 0;
			for (PositionalNotation positionalNotation : pns) {
				i++;
				System.out.format("Positional notation %d:%n", i);
				System.out.print(positionalNotation);
				System.out.println();
			}
		}
		catch (ChordGenerationException e) {
			System.out.println(e.getMessage());
			Logger.error(this, e, "Error generating chord.");
		}

		Logger.debug(this, "Chord notation generation ended.");
	}

}
