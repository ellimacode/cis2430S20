package adventure;

import java.util.Scanner;

public class Parser implements java.io.Serializable {

    private Command command;
    //array of valid action words
    public static final String[] ACTIONS = {"go", "look", "help", "quit", "up", "down",
            "N", "S", "E", "W", "inventory", "take"};

    private static final long serialVersionUID = -3788086098781612036L;

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
            }
            if (tokenizer.hasNext()) {
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
     * @return validActions
     */
    public String allCommands() {
        for (int i = 0; i < ACTIONS.length; i++) {
            return ACTIONS[i];
        }
        return null;
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
