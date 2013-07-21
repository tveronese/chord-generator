package br.com.chordgenerator.commands.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.chordgenerator.commands.*;
import br.com.chordgenerator.logger.Logger;

public class CommandFactory {

    private static List<Command> cmdsList;

    static {

        cmdsList = new ArrayList<Command>();
        try {
            // Add commands to list according to their demanded order
            cmdsList.add(HelpCommand.class.newInstance());
            cmdsList.add(SpecifyInstrumentCommand.class.newInstance());
            cmdsList.add(SpecifyChordCommand.class.newInstance());
        }
        catch (InstantiationException e) {
            Logger.error(CommandFactory.class, e, "Error while inserting commands.");
        }
        catch (IllegalAccessException e) {
            Logger.error(CommandFactory.class, e, "Error while inserting commands.");
        }
    }

    public List<Command> getCommands(String[] args) {

        List<Command> commands = new ArrayList<Command>();
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
                throw new IllegalArgumentException(msg);
            }
        }

        return commands;
    }

    public static List<Command> getCmdsList() {

        return cmdsList;
    }

}
