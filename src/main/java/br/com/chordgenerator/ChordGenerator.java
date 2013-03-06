package br.com.chordgenerator;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.commands.Command;
import br.com.chordgenerator.commands.HelpCommand;
import br.com.chordgenerator.commands.factory.CommandFactory;
import br.com.chordgenerator.logger.Logger;

public class ChordGenerator {

	public static void main(String[] args) {

		Logger.debug(ChordGenerator.class, "Initializing Chord Generator application...");

		List<String[]> argsList = new ArrayList<String[]>();
		argsList.add(new String[] { "-c", "A" });
		argsList.add(new String[] { "-c", "Am" });
		argsList.add(new String[] { "-c", "B" });
		argsList.add(new String[] { "-c", "Bm" });
		argsList.add(new String[] { "-c", "C" });
		argsList.add(new String[] { "-c", "Cm" });
		argsList.add(new String[] { "-c", "D" });
		argsList.add(new String[] { "-c", "Dm" });
		argsList.add(new String[] { "-c", "E" });
		argsList.add(new String[] { "-c", "Em" });
		argsList.add(new String[] { "-c", "F" });
		argsList.add(new String[] { "-c", "Fm" });
		argsList.add(new String[] { "-c", "G" });
		argsList.add(new String[] { "-c", "Gm" });

		ChordGenerator chordGenerator = new ChordGenerator();
		for (String[] strings : argsList) {

			chordGenerator.processArgs(strings);
		}
	}

	private void processArgs(String[] args) {

		Logger.debug(this, format("Parsing %d received arguments: %s", args.length, Arrays.toString(args)));

		if (args.length == 0) {
			Logger.debug(this, "No arguments were provided. Showing help.");
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
