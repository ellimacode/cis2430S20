package adventure;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

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
    private Scanner scnr = new Scanner(System.in);

    //constructor
    public Game() {
        createRooms();
        createItems();
    }

    public static void main(String[] args) {

        /* You will need to instantiate an object of type
        game as we're going to avoid using static methods
        for this assignment */
        Game theGame = new Game();

        // 1. Print a welcome message to the user
        System.out.println();
        System.out.println("-------WELCOME TO THE ADVENTURE GAME!-------");
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
        } else if (inputLine.equals("no")) {
            System.out.println("You are an explorer in a dark haunted cave looking for buried treasure.");
            theGame.runGame();
        }

    }

        /* 7+. Use a game instance method to parse the user
        input to learn what the user wishes to do*/

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
        if (obj != null) {
            Adventure adventure = new Adventure();
            JSONObject main = (JSONObject) obj.get("adventure");

            if (main != null) {

                JSONArray room_list = (JSONArray) obj.get("room");
                JSONArray item_list = (JSONArray) obj.get("item");

                for (Object current_room: room_list) {
                    JSONObject room = (JSONObject) current_room;
                    String room_name = (String) room.get("name");
                    String start_room = (String) room.get("start");
                    String long_description = (String) room.get("long_description");

                }

                for (Object current_item: item_list) {
                    JSONObject item = (JSONObject) current_item;
                    String item_name = (String) item.get("name");
                    String long_description = (String) item.get("long_description");
                }

            }

            return adventure;
        }

        return null;

    }


    /**
     * create rooms for default adventure
     */
    public void createRooms() {
        //creates 6 different rooms
        Room entrance = new Room("The Dark Cave's entrance",
                "You are at the opening gate to the dark cave. The gate was left unlocked.");
        Room main = new Room("The cave's main floor",
                "You are in the cave's main floor. A small lamp on the floor allows you to see.");
        Room closet = new Room("A weapon closet",
                "It is a storage room for armor and weapons. There's a tiny door behind the swords.");
        Room lair = new Room("The Wizard's abandoned lair",
                "You are in the Wizard's old lair. Something is glowing inside the cupboards.");
        Room treasure = new Room("The Treasure Room",
                "JACKPOT!!! You are in the TREASURE ROOM. "
                        + "Jewellery and gold coins pouring out of every treasure chest.");
        Room empty = new Room("A dark empty room",
                "There is a small stepping stool missing one of its legs, and a pile of coal.");

        //in the form of north, south, east, west
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
     * game loop
     */
    public void runGame() {
        do {
            System.out.println("Enter next command: ");
            String user = getCommand();
            gameOver = processCommand(user);

        } while (!gameOver);

        System.out.println("Thanks for playing.");

    }

    /**
     * to get command from user
     * @return input
     */
    public String getCommand() {
        String input = " ";
        System.out.print(">> ");
        input = scnr.nextLine();

        return input;
    }

    /**
     * process the command the user enters
     * @param input
     * @return false
     */
    public boolean processCommand(String input) {
        boolean finished = false;

        //to quit the game use keyword 'quit'
        if (input.equals("quit")) {
            System.out.println("You are quitting the game.");
            finished = true;
        }

        //to show user all valid commands use keyword 'help'
        if (input.equals("help")) {
            System.out.println();
            System.out.println("-------HELPFUL COMMANDS-------");
            System.out.println();
            System.out.println("go (direction) - to go in the direction N/S/E/W");
            System.out.println("look (itemName) - to see description of item");
            System.out.println("look - to see description of room");
            System.out.println("quit - quit game");
            System.out.println();

            finished = false;
        }

        //to move from room to room use keyword 'go'
        if (input.equals("go")) {
            enterRoom(input);
        }

        //prints long description of room use keyword 'look'
        if (input.contains("look")) {
            System.out.println(playerRoom.getLongDescription());
        }

        return finished;
    }

    /**
     * allows user to enter the next room
     * @param input
     */
    public void enterRoom(String input) {
        //get direction (second word)
        String[] splited = input.split(" ");
        String first = splited[0];
        String second = splited[1];

        if (!isDirection(second)) {
            System.out.println("Go where?");
            return;
        } else if (isDirection(second)) {
            System.out.println("You are going " + second);

            Room next = playerRoom.getConnectedRoom(second);

            if (next != null) {
                playerRoom = next;
                System.out.println(playerRoom.getLongDescription());
            } else if (next == null) {
                System.out.println("Enter a different direction.");
            }
        }

    }

    /**
     * checks if second word is a direction
     * @param secondWord
     * @return true/false
     */
    public boolean isDirection(String secondWord) {
        boolean realDirection = false;

        String[] directions = new String[] {"N", "S", "E", "W"};

        if (secondWord.equals(directions[0])) {
            realDirection = true;
        }
        if (secondWord.equals(directions[1])) {
            realDirection = true;
        }
        if (secondWord.equals(directions[2])) {
            realDirection = true;
        }
        if (secondWord.equals(directions[3])) {
            realDirection = true;
        }

        return realDirection;
    }

}
