package adventure;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Game implements java.io.Serializable {

    /* this is the class that runs the game.
    You may need some member variables */
    private boolean gameOver = false;
    private Room currentRoom;
    private Item currentItem;
    private Parser parser;
    private Player player;
    private Scanner scnr = new Scanner(System.in);

    private Adventure adventure;

    private static final long serialVersionUID = -3788086098781612036L;


    //constructor
    public Game() {
        createAdv();
        parser = new Parser();
        player = new Player();

    }

    public static void main(String[] args) {

        /* You will need to instantiate an object of type
        game as we're going to avoid using static methods
        for this assignment */
        Game theGame = new Game();

        // 1. Print a welcome message to the user
        System.out.println();
        System.out.println("----------WELCOME TO THE WORLD OF ADVENTURE GAME!----------");
        System.out.println();

        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter name: ");
        String playerName = scnr.nextLine();

//        System.out.print("Enter filename: ");
//        String filename = scnr.nextLine();
//
//        JSONObject jsonObject = theGame.loadAdventureJson(filename);
//        Adventure adventure = theGame.generateAdventure(jsonObject);
//        ArrayList<Room> rooms = adventure.listAllRooms();
//        ArrayList<Item> items = adventure.listAllItems();

        //default adventure
        System.out.println("You are an explorer in a dark haunted cave "
                + "looking for buried treasure.");
        theGame.runGame();


    }

    /* you must have these instance methods and may need more*/

    /**
     * loads the JSON file, pass in filename
     * @param filename
     * @return advJson (JSONObject)
     */
    public JSONObject loadAdventureJson(String filename){
        JSONObject adv_json = null;

        try (FileReader reader = new FileReader(filename)) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            adv_json = (JSONObject) obj;
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return adv_json;
    }

    /**
     * loads JSON file through InputStream
     * Overloaded method
     * @param inputStream
     * @return adv_json (JSONObject)
     */
    public JSONObject loadAdventureJson(InputStream inputStream){
        JSONObject adv_json = null;

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new InputStreamReader(inputStream));

            adv_json = (JSONObject) obj;

        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return adv_json;
    }

    /**
     * generate adventure based on JSON file
     * @param obj
     * @return adv (Adventure)
     */
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
                        if (loot_id.equals(curr_item.getId())) {
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
     * create rooms and items for default adventure
     */
    public void createAdv() {
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

        entrance.setExits(main, null, null, null, null, null);
        main.setExits(closet, entrance, null, lair, null, underground);
        closet.setExits(null, main, treasure, null, null, null);
        lair.setExits(null, null, main, dark_room, null, null);
        treasure.setExits(null, null, null, closet, null, null);
        dark_room.setExits(null, null, lair, null, null, null);
        underground.setExits(null, null, null, null, main, null);

        currentRoom = entrance;

        Item lamp = new Item("Lamp", "A working gas lamp, bright enough to see what's ahead.");
        Item wand = new Item("Wizard Wand", "It's a glowing wand, left behind in the abandoned lair.");
        Item potion = new Item("Potion Bottle", "A bottle of glowing green potion, labelled 'do not drink'.");

        //items contained in specified rooms
        main.addItem(lamp);
        lair.addItem(wand);
        lair.addItem(potion);
    }

    /**
     * game loop for running json
     */
    public void runJson() {
        do {
            try {
                System.out.print(">> ");
                String user2 = scnr.nextLine();
                Command command2 = parser.parseUserCommand(user2);
                gameOver = followCommand(command2);
            } catch (InvalidCommandException ex) {
                System.out.println(ex.getMessage());
            }

        } while (!gameOver);

        System.out.println("Thanks for playing.");
    }

    /**
     * process user commands for json adventure
     * @param command
     */
    public boolean followCommand(Command command) {
        boolean done = false;

        String userInput = command.getActionWord();

        if (!command.isValid(userInput)) {
            System.out.println("Invalid Command.");
        }

        if (userInput.equals("quit")) {
            adventure.quitPlayer(command);
            done = true;
        }

        if (userInput.equals("help")) {
            adventure.helpPlayer();
            done = false;
        }

        if (userInput.equals("go")) {
            adventure.goPlayer(command);
            done = false;
        }

        if (userInput.equals("look")) {
            if (command.hasSecondWord()) {
                adventure.lookItem(command);
            } else {
                adventure.lookPlayer();
            }
            done = false;
        }

        if (userInput.equals("inventory")) {
            System.out.println("--------INVENTORY--------\n");
            System.out.println(player.getInventory());
            System.out.println("Total # of items: " + player.numItems() + "\n");
            done = false;
        }

        return done;
    }


    /**
     * game loop for default adventure
     */
    public void runGame() {
        do {
            try {
                System.out.print(">> ");
                String user1 = scnr.nextLine();
                Command command1 = parser.parseUserCommand(user1);
                gameOver = processCommand(command1);
            }
            catch (InvalidCommandException ex) {
                System.out.println(ex.getMessage());
            }

        } while (!gameOver);

        System.out.println("Thanks for playing.");

    }

    /**
     * process the command the user enters
     * @param command
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
            System.out.println("\n-------HELPFUL COMMANDS-------\n");
            System.out.println("go (direction) - to go in the direction (N/S/E/W/up/down)");
            System.out.println("look (itemName) - to see description of item");
            System.out.println("look - to see description of current room");
            System.out.println("take (itemName) - to pick up item");
            System.out.println("inventory - to see current inventory");
            System.out.println("quit - quit game\n");

            finished = false;
        }

        //to move from room to room use keyword 'go'
        if (userCommand.contains("go")) {
            enterRoom(command);
            finished = false;
        }

        //prints long description of room use keyword 'look'
        if (userCommand.equals("look")) {

            if (!command.hasSecondWord()) {
                System.out.println(currentRoom.getLongDescription());
                finished = false;
            }
            else if (command.hasSecondWord()) {
                String item_name = command.getNoun();

                if (item_name.equals("lamp")) {
                    currentItem = currentRoom.getItem(0);
                } else if (item_name.equals("wand")) {
                    currentItem = currentRoom.getItem(0);
                } else if (item_name.equals("potion")) {
                    currentItem = currentRoom.getItem(1);
                } else {
                    System.out.println("No item exist.\n");
                }

                System.out.println(currentItem.getLongDescription() + "\n");
            }
        }

        //to take item and add to inventory
        if (userCommand.contains("take")) {
            takeItem(command);
            finished = false;
        }

        //to see inventory
        if (userCommand.equals("inventory")) {
            System.out.println("--------INVENTORY--------\n");
            System.out.println(player.getInventory());
            System.out.println("Total # of items: " + player.numItems() + "\n");
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
            System.out.println("Go where?\n");
            return;
        } else if (command.hasSecondWord()) {
            String direction = command.getNoun();

            if (command.isValid(direction)) {
                Room next = currentRoom.getConnectedRoom(direction);
                if (next != null) {
                    currentRoom = next;
                    System.out.println(currentRoom.getLongDescription());
                } else {
                    System.out.println("No Exit.\n");
                }
            } else {
                System.out.println("Go where?\n");
                return;
            }
        }
    }


    /**
     * allows user to take items
     * @param command
     */
    public void takeItem(Command command) {
        //get item name (second word)
        if (!command.hasSecondWord()) {
            System.out.println("Take what?\n");
            return;
        }

        else if (command.hasSecondWord()) {
            String temp = command.getNoun();

            if (temp.equals("lamp")) {
                currentItem = currentRoom.getItem(0);
            } else if (temp.equals("wand")) {
                currentItem = currentRoom.getItem(0);
            } else if (temp.equals("potion")) {
                currentItem = currentRoom.getItem(1);
            }

            if (currentRoom.containsItem(currentItem)) {
                player.setInventory(currentItem);

                System.out.println("You have taken " + currentItem.getName() + "\n");
            } else {
                System.out.println("The item doesn't exist.\n");
                return;
            }
        }
    }

    /**
     * checks if user wants to save progress of the game
     * @return false
     */
    public boolean saveGame() {
        System.out.println("Do you want to save your progess? (yes or no)");
        System.out.print(">> ");
        String answer = scnr.nextLine();
        answer = answer.toLowerCase();

        /* enter a name to identify my game save when i choose to save
        the game */
        if (answer.equals("yes")) {
            System.out.println("Enter a name:");
            String saveFile = scnr.nextLine();

            Game game = new Game();

            //serialization
            try {
                //saving object in a file
                FileOutputStream outputStream = new FileOutputStream(saveFile);
                ObjectOutputStream outputDest = new ObjectOutputStream(outputStream);

                outputDest.writeObject(game);

                outputDest.close();
                outputStream.close();

                System.out.println("Progress has been saved.");

            } catch (IOException ex) {
                System.out.println(ex);
            }

            return true;
        }

        // player quits the game without saving progress
        else if (answer.equals("no")) {
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return "Room: " + currentRoom + ", Item(s): " + currentItem;
    }


}
