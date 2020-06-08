package adventure;

import java.util.ArrayList;
import java.util.HashMap;

public class Room implements java.io.Serializable {
    /* you will need to add some private member variables */
    private String shortDescription;
    private String longDescription;
    private String roomName;
    private Integer id;
    private HashMap<String, Room> rooms;
    private ArrayList<Item> contents;
    private HashMap<String, Integer> jsonRooms;

    private static final long serialVersionUID = -3788086098781612036L;

    //constructors
    public Room() {
        shortDescription = null;
        longDescription = null;
        roomName = null;
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
        jsonRooms = new HashMap<String, Integer>();
    }

    //based on JSONfile
    public Room(Integer tag, String name, String shortDesc, String longDesc) {
        id = tag;
        roomName = name;
        shortDescription = shortDesc;
        longDescription = longDesc;
        jsonRooms = new HashMap<String, Integer>();
        contents = new ArrayList<Item>();
    }

    //based on default adventure
    public Room(String name, String info) {
        roomName = name;
        longDescription = info;
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
    }

    /* required public methods */

    /**
     * get the list of items
     * @return contents
     */
    public ArrayList<Item> listItems(){
        //lists all the items in the room
        return contents;
    }

    /**
     * set room name
     * @param name
     */
    public void setName(String name) {

        roomName = name;
    }

    /**
     * get room name
     * @return roomName
     */
    public String getName(){
        return roomName;

    }

    /**
     * set room ID
     * @param num
     */
    public void setId(Integer num) {
        id = num;
    }

    /**
     * get room ID
     * @return id
     */
    public Integer getId() {
        return id;
    }


    /**
     * set long description of room
     * @param info
     */
    public void setLongDescription(String info) {
        longDescription = info;
    }

    /**
     * get room's long description
     * @return longDescription
     */
    public String getLongDescription(){
        return longDescription + "\n";

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

    /**
     * add connecting room to hashmap, JSON
     * @param direction
     * @param tag
     */
    public void addConnectedRoom(String direction, Integer tag) {
        jsonRooms.put(direction, tag);
    }

    /* you may wish to add some helper methods*/

    /**
     *
     * @param northExit
     * @param southExit
     * @param eastExit
     * @param westExit
     * @param upExit
     * @param downExit
     */
    public void setExits(Room northExit, Room southExit, Room eastExit, Room westExit,
                         Room upExit, Room downExit) {
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
        if (upExit != null) {
            rooms.put("up", upExit);
        }
        if (downExit != null) {
            rooms.put("down", downExit);
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
     * gets an item from room
     * @param i
     * @return item
     */
    public Item getItem(int i) {
        return contents.get(i);
    }


    /**
     * checks if rooms contains specified item
     * @param item
     * @return true/false
     */
    public boolean containsItem(Item item) {
        if (contents.contains(item)) {
            return true;
        }
        return false;
    }


    /**
     * format string for room
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + roomName + ", " + "Description: " + longDescription + "\n";
        
    }
}
