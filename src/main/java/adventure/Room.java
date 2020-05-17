package adventure;

import java.util.ArrayList;
import java.util.HashMap;

public class Room{
    /* you will need to add some private member variables */

    private String description;
    private String roomName;
    private HashMap<String, Room> rooms;
    private ArrayList<Item> contents = new ArrayList<Item>();

    //constructors
    public Room() {
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
    }

    public Room(String roomName) {
        this.roomName = roomName;
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
        return "You are " + description + ".\n";

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
     * sets a neighboring room based on the direction
     * @param direction
     * @return side the neighboring room
     */
    public void setExits(Room north, Room south, Room east, Room west) {
        if (north != null) {
            rooms.put("north", north);
        }
        if (south != null) {
            rooms.put("south", south);
        }
        if (east != null) {
            rooms.put("east", east);
        }
        if (west != null) {
            rooms.put("west", west);
        }

    }

    //add item to list of items
    public void addItem(Item item) {
        contents.add(item);
    }






}
