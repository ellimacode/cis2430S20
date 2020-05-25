package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

public class Room{
    /* you will need to add some private member variables */
    private String description;
    private String roomName;
    private int ID;
    private HashMap<String, Room> rooms;
    private ArrayList<Item> contents;

    //constructors
    public Room() {
        description = null;
        roomName = null;
        ID = -999;
        rooms = new HashMap<String, Room>();
        contents = new ArrayList<Item>();
    }

//    //based on JSON file
//    public Room(JSONObject roomJSON) {
//        int ID = (int) roomJSON.get("ID");
//        String name = (String) roomJSON.get("name");
//        String long_description = (String) roomJSON.get("long_description");
//
//        this.ID = ID;
//        this.roomName = name;
//        this.description = long_description;
//    }
//
//    public Room(String name, String info, int num) {
//        roomName = name;
//        description = info;
//        ID = num;
//    }

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
