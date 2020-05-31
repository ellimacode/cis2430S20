package adventure;

/* TODO add a static data structure or another enum class
that lists all the valid commands.  Then add methods for validating
commands 

You may add other methods to this class if you wish*/

public class Command implements java.io.Serializable {
    private String action;
    private String noun;

    private static final long serialVersionUID = -3788086098781612036L;

    //array of valid commands
    public static final String[] commands = {"go", "look", "help", "quit", "up", "down",
            "N", "S", "E", "W", "inventory", "take"};

  /**
     * Create a command object with default values.  
     * both instance variables are set to null
     * 
     */
    public Command() throws InvalidCommandException {
        this(null, null);
    }


  /**
     * Create a command object given only an action.  this.noun is set to null
     *
     * @param command The first word of the command. 
     * 
     */
    public Command(String command) throws InvalidCommandException{

        //TODO validate the action word here and throw an exception if it isn't
        // a single-word action
        this(command, null);
    }

    /**
     * Create a command object given both an action and a noun
     *
     * @param command The first word of the command. 
     * @param what      The second word of the command.
     */
    public Command(String command, String what) throws InvalidCommandException{
        //TODO validate the command here and ensure that the noun provided
        // is a legitimate second word for the command
        // throw an exception if not

        this.action = command;
        this.noun = what;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     *
     * @return The command word.
     */
    public String getActionWord() {

        return this.action;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getNoun() {

        return this.noun;
    }



    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord() {

        return (noun != null);
    }


    /**
     * checks if the user command is valid
     * @param command
     * @return true if command is in commands, false otherwise
     */
    public static Boolean isValid(String command) {
        boolean valid = false;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(command)) {
                valid = true;
            }
        }

        return valid;
    }


    @Override
    public String toString() {
        return "Action: " + action + ", Noun: " + noun + "\n";
    }
}
