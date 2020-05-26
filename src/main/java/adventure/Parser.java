package adventure;

import java.util.Scanner;

public class Parser {

    private Scanner scnr;
    private Command command;

    public Parser() {
        scnr = new Scanner(System.in);
        command = new Command();
    }

    /* REQUIRED METHODS */
    public Command parseUserCommand(String userCommand) throws InvalidCommandException {

        String first, second;

        System.out.println(">> ");

        try {
            userCommand = scnr.nextLine();
        }
        //error handler
        catch(InvalidCommandException excep) {
            System.out.println(excep.getMessage());
        }

        //split user command to two words
        String[] splited = userCommand.split(" ");
        first = splited[0];
        second = splited[1];


        //check if command is valid
        if (command.isValid(first)) {
            return new Command(first, second);
        }
        else {
            return new Command(null, second);
        }



    }

    public String allCommands() {

    }
}
