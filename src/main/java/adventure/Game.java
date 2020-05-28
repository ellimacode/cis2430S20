package adventure;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

import javax.lang.model.type.ArrayType;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Game{

    /* this is the class that runs the game.
    You may need some member variables */
    private boolean gameOver = false;
    private Room playerRoom;
    private Item playerItem;
    private Scanner scnr = new Scanner(System.in);
    private Parser parser;


    //constructor
    public Game() {
        createRooms();
        createItems();
        parser = new Parser();
    }

    public static void main(String[] args) {


        /* You will need to instantiate an object of type
        game as we're going to avoid using static methods
        for this assignment */
        Game theGame = new Game();
        Player player = new Player();

        // 1. Print a welcome message to the user
        System.out.println();
        System.out.println("----------WELCOME TO THE WORLD OF ADVENTURE GAME!----------");
        System.out.println();

        // 2. Ask the user if they want to load a json file.

        /* 3. Parse the file the user specified to create the
        adventure, or load your default adventure*/

        // 4. Print the beginning of the adventure

        // 5. Begin game loop here

        // 6. Get the user input. You'll need a Scanner
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter name: ");
        String playerName = scnr.nextLine();
        player.setName(playerName);
        System.out.println("Welcome " + playerName + "!");

        String filename = scnr.nextLine();


        //JSON adventure 
        JSONObject jsonObject = theGame.loadAdventureJson(filename);
        Adventure adventure = theGame.generateAdventure(jsonObject);
        ArrayList<Room> rooms = adventure.listAllRooms();
        ArrayList<Item> items = adventure.listAllItems();

        //default adventure
        System.out.println(player.getLocation());
        theGame.runGame();


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
        Adventure adv;

        //iterate through adventure
        JSONObject advObj = (JSONObject) obj.get("adventure");

        JSONArray roomArray = (JSONArray) advObj.get("room");
        JSONArray itemArray = (JSONArray) advObj.get("item");

        ArrayList<Room> roomList = new ArrayList<Room>();
        ArrayList<Item> itemList = new ArrayList<Item>();

        //iterate through JSONArray for rooms
        for (Object current_room: roomArray) {
            JSONObject playerRoom = (JSONObject) current_room;

            //room's name, ID and description
            Long temp = (Long) playerRoom.get("id");
            Integer room_id = new Integer(temp.intValue());
            String name = (String) playerRoom.get("name");
            String shortDesc = (String) playerRoom.get("short_description");
            String longDesc = (String) playerRoom.get("long_description");

            //seperate JSON arrays for entrances and loot
            JSONArray enterArray = (JSONArray) playerRoom.get("entrance");
            JSONArray lootArray = (JSONArray) playerRoom.get("loot");

            Room nextRoom = new Room(room_id, name, shortDesc, longDesc);

            //iterate through JSONArray for entrances
            if (enterArray != null) {
                for (Object current_ent: enterArray) {
                    JSONObject playerEnt = (JSONObject) current_ent;

                    Long tempId = (Long) playerEnt.get("id");
                    Integer enter_id = new Integer(tempId.intValue());
                    String direction = (String) playerEnt.get("dir");

                    nextRoom.addConnectedRoom(direction, enter_id);
                }
            }

            //iterate through JSONArray for loot
            if (lootArray != null) {
                for (Object current_loot: lootArray) {
                    JSONObject playerLoot = (JSONObject) current_loot;

                    Long temp_id = (Long) playerLoot.get("id");
                    Integer loot_id = new Integer(temp_id.intValue());

                    for (Item curr_item: itemList) {
                        if (loot_id.equals(curr_item.getID())) {
                            nextRoom.addItem(curr_item);
                            curr_item.setContainingRoom(nextRoom);
                            break;
                        }
                    }
                }
            }

            roomList.add(nextRoom);
        }

        //iterate through JSONArray for items
        for (Object current_item: itemArray) {
            JSONObject playerItem = (JSONObject) current_item;

            //item's name, ID and description
            Long temp = (Long) playerItem.get("id");
            Integer id = new Integer(temp.intValue());
            String name = (String) playerItem.get("name");
            String itemDescription = (String) playerItem.get("desc");

            Item nextItem = new Item(id, name, itemDescription);
            itemList.add(nextItem);

        }

        adv = new Adventure(roomList, itemList);

        return adv;
    }


    /**
     * create rooms for default adventure
     */
    public void createRooms() {
        //creates 6 different rooms
        Room entrance = new Room("The Dark Cave's entrance",
                "You are at the opening gate to the dark cave. The gate was left unlocked.");
        Room main = new Room("The Cave's main floor",
                "You are in the cave's main floor. A small lamp on the floor allows you to see.");
        Room closet = new Room("A weapon closet",
                "It is a storage room for armor and weapons. There's a tiny door behind the swords.");
        Room lair = new Room("The Wizard's abandoned lair",
                "You are in the Wizard's old lair. Something is glowing inside the cupboards.");
        Room treasure = new Room("The Treasure Room",
                "JACKPOT!!! You are in the TREASURE ROOM. "
                        + "Jewellery and gold coins pouring out of every treasure chest.");
        Room dark_room = new Room("A dark room",
                "You are in a dark small room. "
                        + "There is a small stepping stool missing one of its legs, and a pile of coal.");
        Room underground = new Room("The Underground", "You are underneath the cave's main floor. "
                + "It's cold and dark.");

        //in the form of north, south, east, west
        entrance.setExits(main, null, null, null, null, null);
        main.setExits(closet, entrance, null, lair, null, underground);
        closet.setExits(null, main, treasure, null, null, null);
        lair.setExits(null, null, main, dark_room, null, null);
        treasure.setExits(null, null, null, closet, null, null);
        dark_room.setExits(null, null, lair, null, null, null);
        underground.setExits(null, null, null, null, main, null);


        //start at entrance of cave
        playerRoom = entrance;

    }

    /**
     * create items for default adventure
     */
    public void createItems() {
        Item lamp = new Item("Lamp", "A working gas lamp, bright enough to see what's ahead.");
        Item wand = new Item("Wizard Wand", "It's a glowing wand, left behind in the abandoned lair.");
        Item potion = new Item("Potion bottle", "A bottle of glowing green potion, labelled 'do not drink'.");

        //first item
        playerRoom.addItem(lamp);

    }


    /**
     * game loop
     */
    public void runGame() {
        do {
            try {
                System.out.print(">> ");
                String user = scnr.nextLine();
                Command command = parser.parseUserCommand(user);
                gameOver = processCommand(command);
            }
            catch (InvalidCommandException ex) {
                System.out.println(ex.getMessage());
            }

        } while (!gameOver);

        System.out.println("Thanks for playing.");

    }


    /**
     * process the command the user enters
     * @param input
     * @return false
     */
    public boolean processCommand(Command command) {
        boolean finished = false;

        String userCommand = command.getActionWord();

        if (!command.isValid(userCommand)) {
            System.out.println("Invalid Command.");
        }

        //to quit the game use keyword 'quit'
        if (userCommand.equals("quit")) {
            System.out.println("You are quitting the game.");
            finished = saveGame();
        }

        //to show user all valid commands use keyword 'help'
        if (userCommand.equals("help")) {
            System.out.println();
            System.out.println("-------HELPFUL COMMANDS-------");
            System.out.println();
            System.out.println("go (direction) - to go in the direction (N/S/E/W/up/down)");
            System.out.println("look (itemName) - to see description of item");
            System.out.println("look - to see description of current room");
            System.out.println("quit - quit game");
            System.out.println();

            finished = false;
        }

        //to move from room to room use keyword 'go'
        if (userCommand.contains("go")) {
            enterRoom(command);
            finished = false;
        }

        //prints long description of room use keyword 'look'
        if (userCommand.equals("look")) {
            System.out.println(playerRoom.getLongDescription());
            finished = false;
        }

        return finished;
    }

    /**
     * allows user to enter the next room
     * @param command
     */
    public void enterRoom(Command command) {
        //get direction (second word)
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        else if (command.hasSecondWord()) {
            String direction = command.getNoun();

            Room next = playerRoom.getConnectedRoom(direction);

            if (next != null) {
                playerRoom = next;
                System.out.println(playerRoom.getLongDescription());
            } else if (next == null) {
                System.out.println("No Exit.");
                System.out.println();
            }
        }

    }

    /**
     * checks if user wants to save progress of the game
     * @return false
     */
    public boolean saveGame() {
        System.out.println("Do you want to save your progess? (yes or no)");
        String answer = scnr.nextLine();
        answer = answer.toLowerCase();

        /* enter a name to identify my game save when i choose to save
        the game */
        if (answer.equals("yes")) {
            System.out.println("Enter a name:");
            String name = scnr.nextLine();
            return true;
        }

        // player quits the game without saving progress
        else if (answer.equals("no")) {
            return true;
        }

        return false;
    }

    //to load default adventure file (JSON)
    public JSONObject loadAdventureJson(InputStream inputStream) {

        return null;
    }


}
