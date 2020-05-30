package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

public class Room{
    /* you will need to add some private member variables */
    private String short_description;
    private String long_description;
    private String roomName;
    private Integer ID;
    private HashMap<String, Room> rooms;
    private ArrayList<Item> contents;

    private HashMap<String, Integer> json_rooms;

    //constructors
    public Room() {
        short_description = null;
        long_description = null;
        roomName = null;
        ID = -999;
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
        json_rooms = new HashMap<String, Integer>();
    }

    //based on JSONfile
    public Room(Integer tag, String name, String short_desc, String long_desc) {
        ID = tag;
        roomName = name;
        short_description = short_desc;
        long_description = long_desc;
        json_rooms = new HashMap<String, Integer>();
    }

    //based on default adventure
    public Room(String name, String info) {
        roomName = name;
        long_description = info;
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

    public Integer getID() {

        return ID;
    }

    /**
     * @return the long description of room
     */
    public String getLongDescription(){
        return long_description + "\n";

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
     * @param id
     */
    public void addConnectedRoom(String direction, Integer id) {

        json_rooms.put(direction, id);
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


    @Override
    public String toString() {
        return "Room{" +
                "short_description='" + short_description + '\'' +
                ", long_description='" + long_description + '\'' +
                ", roomName='" + roomName + '\'' +
                ", ID=" + ID +
                ", rooms=" + rooms +
                ", contents=" + contents +
                '}';
    }
}
