package adventure;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    /**
     * constructor
     */
    public Game() {
        createAdv();
        parser = new Parser();
        player = new Player();
    }

    public static void main(String[] args) {
        Game theGame = new Game();
        if (args.length == 0) {
            System.out.println("\n----------WELCOME TO THE WORLD OF ADVENTURE GAME!----------\n");
            System.out.println("You are an explorer in a dark haunted cave "
                    + "looking for buried treasure.");
            theGame.runGame();
        } else {
            if (args[0].equals("-a")) {
                JSONObject jsonObject = theGame.loadAdventureJson(args[1]);
                Adventure adventure = theGame.generateAdventure(jsonObject);
                ArrayList<Room> rooms = adventure.listAllRooms();
                ArrayList<Item> items = adventure.listAllItems();
                theGame.runJson();
            } else if (args[0].equals("-l")) {
                System.out.println("\n----------WELCOME BACK " + args[1] + "----------\n");
            }
        }
    }

    /* you must have these instance methods and may need more*/

    /**
     * loads the JSON file, pass in filename
     * @param filename
     * @return advJson (JSONObject)
     */
    public JSONObject loadAdventureJson(String filename){
        JSONObject advJson = null;

        try (FileReader reader = new FileReader(filename)) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            advJson = (JSONObject) obj;
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return advJson;
    }

    /**
     * loads JSON file through InputStream
     * Overloaded method
     * @param inputStream
     * @return adv_json (JSONObject)
     */
    public JSONObject loadAdventureJson(InputStream inputStream){
        JSONObject advJson1 = null;
        try {
            JSONParser parser1 = new JSONParser();
            Object obj = parser1.parse(new InputStreamReader(inputStream));
            advJson1 = (JSONObject) obj;
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return advJson1;
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
        for (Object currentR: roomArray) {
            JSONObject playerRoom = (JSONObject) currentR;

            //room's name, ID and description
            Long temp = (Long) playerRoom.get("id");
            Integer roomId = new Integer(temp.intValue());
            String name = (String) playerRoom.get("name");
            String shortDesc = (String) playerRoom.get("short_description");
            String longDesc = (String) playerRoom.get("long_description");
            Room nextRoom = new Room(roomId, name, shortDesc, longDesc);

            JSONArray enterArray = (JSONArray) playerRoom.get("entrance");
            JSONArray lootArray = (JSONArray) playerRoom.get("loot");

            //iterate through JSONArray for entrances
            if (enterArray != null) {
                for (Object currentEnt: enterArray) {
                    JSONObject playerEnt = (JSONObject) currentEnt;
                    Long tempId = (Long) playerEnt.get("id");
                    Integer enterId = new Integer(tempId.intValue());
                    String direction = (String) playerEnt.get("dir");

                    nextRoom.addConnectedRoom(direction, enterId);
                }
            }

            //iterate through JSONArray for loot
            if (lootArray != null) {
                for (Object currentLoot: lootArray) {
                    JSONObject playerLoot = (JSONObject) currentLoot;
                    Long tempId = (Long) playerLoot.get("id");
                    Integer lootId = new Integer(tempId.intValue());

                    for (Item currItem: itemList) {
                        if (lootId.equals(currItem.getId())) {
                            nextRoom.addItem(currItem);
                            currItem.setContainingRoom(nextRoom);
                            break;
                        }
                    }
                }
            }
            roomList.add(nextRoom);
        }

        //iterate through JSONArray for items
        for (Object currentI: itemArray) {
            JSONObject playerItem = (JSONObject) currentI;

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
                "You are in the cave's main floor. A lamp on the floor allows you to see.");
        Room closet = new Room("A weapon closet",
                "It's a storage room for armor and weapons. A cape fell on the floor."
                        + " There's a tiny door behind the swords.");
        Room lair = new Room("The Wizard's abandoned lair",
                "You are in the Wizard's old lair. Something is glowing inside the cupboards, it's a potion.");
        Room treasure = new Room("The Treasure Room",
                "JACKPOT!!! It is the TREASURE ROOM. "
                        + "Jewellery and gold coins pouring out of treasure chests.");
        Room darkRoom = new Room("A dark room",
                "You are in a dark small room. "
                        + "There is an apple sitting on top of a broken stepping stool.");
        Room underground = new Room("The Underground", "You are underneath the cave's main floor. "
                + "There's a glowing stick, maybe it's a wand.");
        entrance.setExits(main, null, null, null, null, null);
        main.setExits(closet, entrance, null, lair, null, underground);
        closet.setExits(null, main, treasure, null, null, null);
        lair.setExits(null, null, main, darkRoom, null, null);
        treasure.setExits(null, null, null, closet, null, null);
        darkRoom.setExits(null, null, lair, null, null, null);
        underground.setExits(null, null, null, null, main, null);

        currentRoom = entrance;

        Item lamp = new Item("Lamp", "A working gas lamp, bright enough to see what's ahead.");
        Item wand = new Item("Wizard Wand", "It's a glowing wand, probably from the abandoned lair.");
        Item potion = new Spell("Potion Bottle", "A bottle of glowing green potion, labelled 'do not drink'.");
        Item apple = new Food("Apple", "A shiny, red apple. It's okay to eat it.");
        Item cape = new Clothing("Red Cape", "A red velvety cape, probably worn by the King.");
        main.addItem(lamp);
        underground.addItem(wand);
        lair.addItem(potion);
        darkRoom.addItem(apple);
        closet.addItem(cape);
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
     * @return done
     */
    public boolean followCommand(Command command) {
        boolean done = false;
        String userInput = command.getActionWord();
        if (!command.isValid(userInput)) {
            System.out.println("Invalid Command.");
        } else if (userInput.equals("quit")) {
            adventure.quitPlayer();
            done = true;
        } else if (userInput.equals("help")) {
            adventure.helpPlayer();
        } else if (userInput.equals("go")) {
            adventure.goPlayer(command);
        } else if (userInput.equals("look")) {
            if (command.hasSecondWord()) {
                adventure.lookItem(command);
            } else {
                adventure.lookPlayer();
            }
        } else if (userInput.equals("inventory")) {
            System.out.println("--------INVENTORY--------\n");
            System.out.println(player.getInventory());
            System.out.println("Total # of items: " + player.numItems() + "\n");
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
            } catch (InvalidCommandException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!gameOver);
        System.out.println("Thanks for playing.");
    }

    /**
     * process the command the user enters
     * @param command
     * @return finished
     */
    public boolean processCommand(Command command) {
        boolean finished = false;
        if (!command.isValid(command.getActionWord())) {
            System.out.println("Invalid Command.\n");
        }
        if (command.getActionWord().equals("quit")) {
            finished = saveGame();
        } else if (command.getActionWord().equals("help")) {
            helpGame();
            finished = false;
        } else if (command.getActionWord().contains("go")) {
            enterRoom(command);
            finished = false;
        } else if (command.getActionWord().equals("look")) {
            finished = false;
            if (!command.hasSecondWord()) {
                System.out.println(currentRoom.getLongDescription());
            } else if (command.hasSecondWord()) {
                lookItem(command);
            }
        } else if (command.getActionWord().contains("take")) {
            takeItem(command);
            finished = false;
        } else if (command.getActionWord().equals("inventory")) {
            checkInventory();
            finished = false;
        } else if (command.getActionWord().equals("eat")) {
            eatItem(command);
            finished = false;
        } else if (command.getActionWord().equals("wear")) {
            wearItem(command);
            finished = false;
        } else if (command.getActionWord().equals("toss")) {
            tossItem(command);
            finished = false;
        } else if (command.getActionWord().equals("read")) {
            readItem(command);
            finished = false;
        }
        return finished;
    }

    /**
     * allows user to enter the next room
     * @param command
     */
    public void enterRoom(Command command) {
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
            }
        }
    }


    /**
     * allows user to take items
     * @param command
     */
    public void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Take what?\n");
            return;
        } else if (command.hasSecondWord()) {
            currentItem = validItem(command.getNoun());
            if (currentRoom.containsItem(currentItem)) {
                player.addInventory(currentItem);
                System.out.println("You have taken " + currentItem.getName() + "\n");
            } else {
                System.out.println("The item doesn't exist.\n");
            }
        }
    }



    /**
     * allows user to look at an item's description
     * @param command
     */
    public void lookItem(Command command) {
        if (command.getNoun().equals("lamp")) {
            currentItem = currentRoom.getItem(0);
        } else if (command.getNoun().equals("wand")) {
            currentItem = currentRoom.getItem(0);
        } else if (command.getNoun().equals("potion")) {
            currentItem = currentRoom.getItem(0);
        } else if (command.getNoun().equals("cape")) {
            currentItem = currentRoom.getItem(0);
        } else if (command.getNoun().equals("apple")) {
            currentItem = currentRoom.getItem(0);
        } else {
            System.out.println("No item exist.\n");
        }
        System.out.println(currentItem.getLongDescription() + "\n");
    }

    /**
     * allows user to check current inventory
     */
    public void checkInventory() {
        System.out.println("--------INVENTORY--------\n");
        System.out.println(player.getInventory());
        System.out.println("Total # of items: " + player.numItems() + "\n");
    }

    /**
     * allow user to eat item, if edible
     * @param command
     */
    public void eatItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Eat what?\n");
            return;
        } else {
            if (command.getNoun().equals("apple")) {
                currentItem = currentRoom.getItem(0);
                if (currentItem instanceof Edible) {
                    System.out.println(((Edible)currentItem).eat());
                    player.removeItem(currentItem);
                }
            } else {
                System.out.println("Item cannot be eaten.\n");
            }
        }
    }

    /**
     * allow user to wear item, if wearable
     * @param command
     */
    public void wearItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Wear what?\n");
            return;
        } else {
            if (command.getNoun().equals("cape")) {
                currentItem = currentRoom.getItem(0);
                if (currentItem instanceof Wearable) {
                    System.out.println(((Wearable)currentItem).wear());
                }
            } else {
                System.out.println("Item cannot be worn.\n");
            }
        }
    }

    /**
     * allow user to toss item, if tossable
     * @param command
     */
    public void tossItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Toss what?\n");
            return;
        } else {
            if (command.getNoun().equals("apple")) {
                currentItem = validItem(command.getNoun());
                if (currentItem instanceof Tossable) {
                    System.out.println(((Tossable)currentItem).toss());
                    player.removeItem(currentItem);
                }
            } else {
                System.out.println("Item cannot be tossed.\n");
            }
        }
    }
    
    /**
     * allow user to read item, if readable
     * @param command
     */
     public void readItem(Command command) {
         if (!command.hasSecondWord()) {
             System.out.println("Read what?\n");
             return;
         } else {
             if (command.getNoun().equals("potion")) {
                 currentItem = validItem(command.getNoun());
                 if (currentItem instanceof Readable) {
                     System.out.println(((Readable)currentItem).read());
                 }
             } else {
                 System.out.println("Item cannot be read.\n");
             }
         }
     }

    /**
     * prints out helpful commands to user
     */
    public void helpGame() {
        System.out.println("\n-------HELPFUL COMMANDS-------\n");
        System.out.println("go (direction) - to go in the direction (N/S/E/W/up/down)");
        System.out.println("look - to see description of current room/item");
        System.out.println("take - to pick up item");
        System.out.println("inventory - to see current inventory");
        System.out.println("eat - to eat edible item");
        System.out.println("wear - to wear clothing item");
        System.out.println("toss - to throw item");
        System.out.println("read - to read labelled item");
        System.out.println("quit - quit game\n");
    }

    /**
     * checks if user wants to save progress of the game
     * @return false
     */
    public boolean saveGame() {
        System.out.println("Do you want to save your progess? (yes or no)");
        System.out.print(">> ");
        String answer = scnr.nextLine();
        if (answer.equals("yes")) {
            System.out.println("Enter a name:");
            String saveFile = scnr.nextLine();
            Game game = new Game();
            try {
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
        } else if (answer.equals("no")) {
            return true;
        }
        return false;
    }

    /**
     * returns a valid item based on string
     * @param temp
     * @return currentItem
     */
    public Item validItem(String temp) {
        if (temp.equals("lamp")) {
            currentItem = currentRoom.getItem(0);
        } else if (temp.equals("wand")) {
            currentItem = currentRoom.getItem(0);
        } else if (temp.equals("potion")) {
            currentItem = currentRoom.getItem(0);
        } else if (temp.equals("apple")) {
            currentItem = currentRoom.getItem(0);
        } else if (temp.equals("cape")) {
            currentItem = currentRoom.getItem(0);
        }
        return currentItem;
    }



    /**
     * format string for game class
     * @return
     */
    @Override
    public String toString() {

        return "Room: " + currentRoom + ", Item(s): " + currentItem;
    }


}
