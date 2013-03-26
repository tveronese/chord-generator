package br.com.chordgenerator;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.commands.Command;
import br.com.chordgenerator.commands.HelpCommand;
import br.com.chordgenerator.commands.factory.CommandFactory;
import br.com.chordgenerator.logger.Logger;

public class ChordGenerator {

	public static void main(String[] args) {

		Logger.debug(ChordGenerator.class, "Initializing Chord Generator application...");
		ChordGenerator.processArgs(args);
	}

	private static void processArgs(String[] args) {

		Logger.debug(ChordGenerator.class, format("Parsing %d received arguments: %s", args.length, Arrays
				.toString(args)));

		if (args.length == 0) {
			Logger.debug(ChordGenerator.class, "No arguments were provided. Showing help.");
			new HelpCommand().execute();
			System.exit(0);
		}

		CommandFactory factory = new CommandFactory();
		List<Command> commands = factory.getCommands(args);

		// Run commands
		for (Command command : commands) {
			command.execute();
		}
	}
}
