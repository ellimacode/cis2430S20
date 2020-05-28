package adventure;

import java.util.Scanner;

public class Parser {

    private Command command;

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

    public String allCommands() {
        return null;

    }

    @Override
    public String toString() {
        return "Parser{" +
                "command=" + command +
                '}';
    }
}
