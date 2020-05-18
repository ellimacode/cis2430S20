package adventure;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;

public class Game{

    /* this is the class that runs the game.
    You may need some member variables */
    private boolean gameOver = false;
    private Room playerRoom;
    private Item playerItem;

    public Game() {
        createRooms();
        createItems();
    }

    public static void main(String args[]) {

        /* You will need to instantiate an object of type
        game as we're going to avoid using static methods
        for this assignment */
        Game theGame = new Game();

        // 1. Print a welcome message to the user
        System.out.println();
        System.out.println("/----WELCOME TO COLOSSAL CASTLE ADVENTURE!----/");
        System.out.println();

        // 2. Ask the user if they want to load a json file.

        /* 3. Parse the file the user specified to create the
        adventure, or load your default adventure*/

        // 4. Print the beginning of the adventure

        // 5. Begin game loop here

        // 6. Get the user input. You'll need a Scanner
        Scanner scnr = new Scanner(System.in);

        System.out.println("Would you like to load a json file (yes or no)?");
        String inputLine = scnr.nextLine();

        if (inputLine.equals("yes")) {
            System.out.println("Enter filename: ");
            String filename = scnr.next();
            theGame.loadAdventureJson(filename);
        }

        else if (inputLine.equals("no")) {
            System.out.println("Default adventure.");
            theGame.runGame();
        }

    }

        /* 7+. Use a game instance method to parse the user
        input to learn what the user wishes to do*/

    //game loop
    public void runGame() {
        do {
            System.out.println("Enter next command: ");
            String user = getCommand();
            gameOver = processCommand(user);

        } while (!gameOver);

        System.out.println("Thanks for playing.");

    }

        //use a game instance method to execute the users wishes*/

        /* if the user doesn't wish to quit,
        repeat the steps above*/


    /* you must have these instance methods and may need more*/

    public JSONObject loadAdventureJson(String filename){
        JSONObject mainObject = new JSONObject();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {

            Object obj = jsonParser.parse(reader);

        } catch (FileNotFoundException e) {
            System.out.println(e);
            mainObject = null;
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return mainObject;
    }

    public Adventure generateAdventure(JSONObject obj) {

          return null;

    }

    /**
     * to get command from user
     * @return input
     */
    public String getCommand() {
        String input = " ";
        String one = null;
        String two = null;
        Scanner reader = new Scanner(System.in);

        System.out.println(">> ");
        input = reader.nextLine();

        Scanner tokenizer = new Scanner(input);
        if (tokenizer.hasNext()) {
            one = tokenizer.next();
            if (tokenizer.hasNext()) {
                two =tokenizer.next();
            }
        }
        return input;
    }

    /**
     * process the command the user enters
     * @param input
     * @return false
     */
    public boolean processCommand(String input) {
        input = input.toLowerCase();

        //to quit the game use keyword 'quit'
        if (input.equals("quit")) {
            System.out.println("Quit what?");
            return false;
        }

        //to show user all valid commands use keyword 'help'
        if (input.equals("help")) {
            System.out.println("Here are some helpful commands:");
            System.out.println("go (direction) - to move in the direction (N,S,E,W)");
            System.out.println("look (itemName) - to see description of item");
            System.out.println("look - to see description of room");
            System.out.println("quit - quit game");
        }

        //to move from room to room use keyword 'go'
        if (input.contains("go")) {
            enterRoom(input);
        }

        //prints long description of room use keyword 'look'
        if (input.contains("look")) {
            System.out.println(playerRoom.getLongDescription());
            System.out.println(playerRoom.listItems());
        }
        return false;
    }

    /**
     * create rooms for default adventure
     */
    public void createRooms() {
        //creates 6 different rooms
        Room entrance = new Room("Opening gate to the dark cave");
        Room main = new Room("The cave's main floor");
        Room closet = new Room("A weapon closet");
        Room lair = new Room("The Wizard's abandoned lair");
        Room treasure = new Room("The Treasure Room");
        Room empty = new Room("A dark empty room");

        //north, south, east, west
        entrance.setExits(main, null, null, null);
        main.setExits(closet, entrance, null, lair);
        closet.setExits(null, main, treasure, null);
        lair.setExits(null, null, main, empty);
        treasure.setExits(null, null, null, closet);
        empty.setExits(null, null, lair, null);

        //start at entrance of cave
        playerRoom = entrance;

    }

    /**
     * create items for default adventure
     */
    public void createItems() {
        Item lamp = new Item("Lamp", "A rusted gas lamp");
        Item wand = new Item("Wizard Wand", "The glowing wand was left behind in the abandoned lair.");
        Item potion = new Item("Potion bottle", "A bottle of glowing green potion, which is labelled 'do not drink'.");

        //first item
        playerRoom.addItem(lamp);

    }

    /**
     * allows user to enter the next room
     * @param input
     */
    public void enterRoom(String input) {
        String direction = input.substring(input.indexOf(' ') + 1, input.length()).trim();

        if (!input.contains(direction)) {
            System.out.println("Go where?");
            return;
        }

        else if (input.contains(direction)) {
            Room next = playerRoom.getConnectedRoom(direction);

            if (next == null) {
                System.out.println("Enter a different direction.");
            }

            else if (next != null) {
                playerRoom = next;
                System.out.println(playerRoom.getLongDescription());
            }
        }
    }

    //allow user to look at items in room
//    public void lookItems(String input) {
//        String thing = input.substring(input.indexOf(' ') + 1, input.length()).trim();
//
//        if (!input.contains(thing)) {
//            System.out.println("Look what?");
//            return;
//        }
//
//        else if (input.contains(thing)) {
//            if (playerRoom.getName().equals(thing)) {
//                System.out.println("Display long description of item");
//                System.out.println(playerRoom)
//            }
//        }
//    }



}
