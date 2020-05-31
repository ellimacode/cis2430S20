package adventure;

import java.util.Scanner;

public class Parser implements java.io.Serializable {

    private Command command;
    //array of valid action words
    public static final String[] validActions = {"go", "look", "help", "quit", "up", "down",
            "N", "S", "E", "W", "inventory", "take"};

    private static final long serialVersionUID = -3788086098781612036L;

    /* REQUIRED METHODS */
    public Command parseUserCommand(String userCommand) throws InvalidCommandException {

        String first;
        String second;

        try {
            Scanner tokenizer = new Scanner(userCommand);

            if (tokenizer.hasNext()) {
                first = tokenizer.next();
            } else {
                first = null;
            }

            if (tokenizer.hasNext()) {
                second = tokenizer.next();
            } else {
                second = null;
            }

            if (command.isValid(first)) {
                return new Command(first, second);
            } else {
                return new Command(null, second);
            }


        } catch(InvalidCommandException ex) {
            throw new InvalidCommandException("Invalid Command. Please try again!");
        }

    }

    /**
     * get all valid action words
     * @return validActions
     */
    public String allCommands() {
        for (int i = 0; i < validActions.length; i++) {
            return validActions[i];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Command: " + command;
    }
}
