package adventure;

import java.util.ArrayList;
import java.util.HashMap;

public class Room{
    /* you will need to add some private member variables */
    private String description;
    private String roomName;
    private HashMap<String, Room> rooms;
    private ArrayList<Item> contents;

    //constructors
    public Room() {
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
    }

    public Room(String name, String info) {
        roomName = name;
        description = info;
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
    }

    /* required public methods */

    public ArrayList<Item> listItems(){
        //lists all the items in the room
        return contents;
    }

    /**
     * @return roomName String
     */
    public String getName(){
        return roomName;

    }

    /**
     * @return the long description of room
     */
    public String getLongDescription(){
        return description + "\n";

    }

    /**
     * Return the room that is connected in the
     * specified direction
     * @param direction
     * @return the room in the given direction
     */
    public Room getConnectedRoom(String direction) {

        return rooms.get(direction);
    }

    /* you may wish to add some helper methods*/

    /**
     *
     * @param northExit
     * @param southExit
     * @param eastExit
     * @param westExit
     */
    public void setExits(Room northExit, Room southExit, Room eastExit, Room westExit) {
        if (northExit != null) {
            rooms.put("N", northExit);
        }
        if (southExit != null) {
            rooms.put("S", southExit);
        }
        if (eastExit != null) {
            rooms.put("E", eastExit);
        }
        if (westExit != null) {
            rooms.put("W", westExit);
        }

    }

    /**
     * adds items to list of items
     * @param item
     */
    public void addItem(Item item) {
        contents.add(item);
    }


    /**
     * checks if rooms contains specified item
     * @param itemName
     * @return true/false
     */
    public boolean containsItem(String itemName) {
        if (contents.contains(itemName)) {
            return true;
        }
        return false;
    }






}
