package br.com.chordgenerator.commands.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.commands.Command;
import br.com.chordgenerator.commands.GenerateChordCommand;
import br.com.chordgenerator.commands.GenerateChordImageCommand;
import br.com.chordgenerator.commands.HelpCommand;
import br.com.chordgenerator.logger.Logger;

public class CommandFactory {

	private static List<Command> cmdsList;

	static {

		cmdsList = new ArrayList<>();
		try {
			// Add commands to list according to their demanded order
			cmdsList.add(HelpCommand.class.newInstance());
			// cmdsList.add(SpecifyInstrumentCommand.class.newInstance());
			cmdsList.add(GenerateChordCommand.class.newInstance());
			cmdsList.add(GenerateChordImageCommand.class.newInstance());
		}
		catch (InstantiationException | IllegalAccessException e) {
			Logger.error(CommandFactory.class, e, "Error while inserting commands.");
		}
	}

	public List<Command> getCommands(String[] args) {

		List<Command> commands = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {

			String arg = args[i];

			boolean foundCmd = false;
			for (Command command : getCmdsList()) {
				if (arg.equalsIgnoreCase("-" + command.getArgument())) {
					int to = i + command.getNumberOfArgs();
					command.setArguments(Arrays.copyOfRange(args, i + 1, to + 1));
					i = to;
					commands.add(command);
					foundCmd = true;
					break;
				}
			}

			if (!foundCmd) {
				String msg = String.format("Command \"%s\" does not exist.", arg);
				IllegalArgumentException e = new IllegalArgumentException(msg);
				throw e;
			}
		}

		return commands;
	}

	public static List<Command> getCmdsList() {

		return cmdsList;
	}

}
