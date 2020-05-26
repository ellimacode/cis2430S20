package adventure;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private ArrayList<Item> inventory;
    private String name;
    private String location;
    private Room currentRoom;

    //constructor
    public Player() {
        inventory = new ArrayList<Item>();
        location = "You are an explorer in a dark haunted cave " +
                "looking for buried treasure.";

        currentRoom = new Room();
    }

    /* REQUIRED METHODS */

    public String getName() {

        return name;
    }

    /**
     * get the player's inventory
     * @return inventory
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * get the player's current location in the game
     * @return location
     */
    public String getLocation() {

        return location;
    }

    /**
     * get the current room
     * @return currentRoom
     */
    public Room getCurrentRoom() {

        return currentRoom;
    }

    /**
     * get the name saved under the game
     * @return null for now
     */
    public String getSaveGameName() {

        return null;
    }






}
