package adventure;

import java.util.ArrayList;
import java.util.HashMap;

public class Room{
    /* you will need to add some private member variables */

    private String description;
    private String roomName;
    private ArrayList<Item> contents;
    private HashMap<String, Room> rooms;

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
     * @return the room description
     */
    public String getLongDescription(){
        return description;

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
    public void setRoom(String direction, Room side) {
        rooms.put(direction, side);
    }


}
