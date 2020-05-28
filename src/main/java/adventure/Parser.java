package adventure;

import java.util.Scanner;

public class Parser {

    private Command command;

    /* REQUIRED METHODS */
    public Command parseUserCommand(String userCommand) throws InvalidCommandException {

        try {

            //split user command to two words
            String[] splited = userCommand.split(" ");
            String first = splited[0];
            String second = splited[1];

            if (command.isValid(first)) {
                return new Command(first, second);
            }
            else {
                return new Command(null, second);
            }


        } catch(InvalidCommandException ex) {
            throw new InvalidCommandException("Invalid Command. Please try again!");
        }

    }

    public String allCommands() {
        return null;

    }
}
