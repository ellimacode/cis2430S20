package adventure;

import java.util.ArrayList;

public class Room{
    /* you will need to add some private member variables */

    private String description; 
    private String name; 
    private ArrayList<Item> contents = new ArrayList<Item>();
    private Room room = new Room();

    /* required public methods */

    public ArrayList<Item> listItems(){
        //lists all the items in the room
        return this.contents;

    }

    public String getName(){
        return this.name; 

    }


    /**
     *
     * @return room description 
     */
    public String getLongDescription(){
        return this.description;

    }

    public Room getConnectedRoom(String direction) {
        return this.room;

    }

    /* you may wish to add some helper methods*/
}