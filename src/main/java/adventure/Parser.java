package adventure;

import java.util.Scanner;
import java.util.StringJoiner;

public class Parser {

    private Command command;

    /**
     * parses user input to create valid command
     * @param userCommand
     * @return command
     * @throws InvalidCommandException
     */
    public Command parseUserCommand(String userCommand) throws InvalidCommandException {
        String first = null;
        String second = null;
        try {
            Scanner tokenizer = new Scanner(userCommand);
            if (tokenizer.hasNext()) {
                first = tokenizer.next();
            } else if (tokenizer.hasNext()) {
                second = tokenizer.next();
            }
            if (command.isValid(first)) {
                return new Command(first, second);
            } else {
                return new Command(null, second);
            }
        } catch(InvalidCommandException ex) {
            throw new InvalidCommandException("Invalid Command!");
        }
    }

    /**
     * get all valid action words
     * @return allActions
     */
    public String allCommands() {
        String[] actions = command.getCommands();
        StringJoiner joiner = new StringJoiner("/");
        for (int i = 0; i < actions.length; i++) {
            joiner.add(actions[i]);
        }
        String allActions = joiner.toString();
        return allActions;
    }

    /**
     * format string for command
     * @return
     */
    @Override
    public String toString() {
        return "Command: " + command;
    }
}
