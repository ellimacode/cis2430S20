package adventure;

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

    public String getName() {
        return name;
    }

    /**
     * get the player's current location in the game
     * @return location
     */
    public String getLocation() {
        return location;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }






}
