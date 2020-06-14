| method sig | responsibility | instance vars used | other class methods called | objects used with method calls | lines of code |
|:----------:|:--------------:|:------------------:|:--------------------------:|:------------------------------:|:-------------:|
|parseUserCommand(String userCommand) throws InvalidCommandException| parses user input (String) into valid command, two different words |Command command|-|Command command, InvalidCommandException ex| 18|
|allCommands()| getter/accessor method, returns all the valid commands |Command command|toString()|Command command| 7|
|toString| format string for Parser class |Command command|-| - | 1|
