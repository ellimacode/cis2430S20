package adventure;

import java.util.ArrayList;

public class Item{
    /* you will need to add some private member variables */

    private String itemName;
    private String description;
    private Room room = new Room();

    /* required public methods */

    /**
     * @return item's name
     */
    public String getName(){
        return this.itemName;

    }

    /**
     * @return item's description
     */
    public String getLongDescription(){
        return this.description;

    }

    public Room getContainingRoom(){
        //returns a reference to the room that contains the item
//        return room.contains(itemName); //FIXME
        return null; 
    }

    /* you may wish to add some helper methods*/

}
