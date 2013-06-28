package br.com.chordgenerator;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.commands.Command;
import br.com.chordgenerator.commands.Configuration;
import br.com.chordgenerator.commands.HelpCommand;
import br.com.chordgenerator.commands.factory.CommandFactory;
import br.com.chordgenerator.facade.ChordGeneratorFacade;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.InstrumentType;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.logger.Logger;

public class ChordGenerator {

	public static void main(String[] args) {

		Logger.debug(ChordGenerator.class, "Initializing Chord Generator application...");
		ChordGenerator generator = new ChordGenerator();
		Configuration configuration = generator.processArgs(args);
		generator.generateChord(configuration);
	}

	protected Configuration processArgs(String[] args) {

		Logger.debug(ChordGenerator.class, format("Parsing %d received arguments: %s", args.length, Arrays
				.toString(args)));

		Configuration configuration = new Configuration();
		if (args.length == 0) {
			Logger.debug(ChordGenerator.class, "No arguments were provided. Showing help.");
			new HelpCommand().execute(configuration);
			System.exit(0);
		}

		CommandFactory factory = new CommandFactory();
		List<Command> commands = factory.getCommands(args);

		// Run commands
		for (Command command : commands) {
			command.execute(configuration);
		}

		return configuration;
	}

	protected void generateChord(Configuration configuration) {

		InstrumentType type = configuration.getType();
		String chord = configuration.getChord();

		Logger.debug(this, "Generating chord \"%s\" positional notation.", chord);

		try {
			List<PositionalNotation> pns = ChordGeneratorFacade.generateChordPositionalNotations(type, chord);
			System.out.format("Generated %d positional notation(s) for chord \"%s\":%n", pns.size(), chord);

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
