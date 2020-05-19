package adventure;

import java.util.ArrayList;

public class Item{
    /* you will need to add some private member variables */

    private String itemName;
    private String description;
    private Room room = new Room();
    private ArrayList<Item> items = new ArrayList<Item>();


    public Item(String name, String info) {
        itemName = name;
        description = info;
    }

    /* required public methods */

    /**
     * @return item's name
     */
    public String getName(){

        return itemName;
    }

    /**
     * @return item's description
     */
    public String getLongDescription(){

        return description;
    }

    public Room getContainingRoom(){
        //returns a reference to the room that contains the item
        if (room.containsItem(itemName)) {
            return this.room;
        }
        return null; 
    }

    /* you may wish to add some helper methods*/

}
