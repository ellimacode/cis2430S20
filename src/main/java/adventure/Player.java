package adventure;

import java.util.ArrayList;

public class Player implements java.io.Serializable {

    private ArrayList<Item> inventory;
    private String name;
    private String location;
    private Room currentRoom;
    private String saveName;

    private static final long serialVersionUID = -3788086098781612036L;

    /**
     * constructor 1, no parameters
     */
    public Player() {
        inventory = new ArrayList<Item>();

    }

    /**
     * constructor 2
     * @param player
     */
    public Player(String player) {
        name = player;
        inventory = new ArrayList<Item>();

    }

    /**
     * set the name of player
     * @param playerName
     */
    public void setName(String playerName) {

        name = playerName;
    }

    /**
     * get the name of player
     * @return name
     */
    public String getName() {

        return name;
    }

    /**
     * add item to list of inventory
     * @param item
     */
    public void addInventory(Item item) {
        if (!inventory.contains(item)) {
            inventory.add(item);
        }
    }

    /**
     * get the player's inventory
     * @return inventor2y
     */
    public ArrayList<Item> getInventory() {

        return inventory;
    }

    /**
     * remove item from inventory
     * @param item
     */
    public void removeItem(Item item) {

        inventory.remove(item);
    }

    /**
     * set the player's location
     * @param place
     */
    public void setLocation(String place) {

        location = place;
    }

    /**
     * get the player's current location in the game
     * @return location
     */
    public String getLocation() {

        return location;
    }

    /**
     * set room as player's current room
     * @param room
     */
    public void setCurrentRoom(Room room) {

        currentRoom = room;
    }

    /**
     * get the current room
     * @return currentRoom
     */
    public Room getCurrentRoom() {

        return currentRoom;
    }

    /**
     * set the saved name as save game name
     * @param save
     */
    public void setSaveName(String save) {

        saveName = save;
    }

    /**
     * get the name saved under the game
     * @return saveName
     */
    public String getSaveName() {

        return saveName;
    }

    /**
     * the number of totals items in inventory
     * @return inventory.size()
     */
    public int numItems() {

        return inventory.size();
    }





}
