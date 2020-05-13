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
        for (int i = 0; i < contents.size(); i++) {
            System.out.println("Item: " + contents.get(i));
        }
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
        if (direction == "N") {
            System.out.println("Go North");
        }

        else if (direction == "S") {
            System.out.println("Go South");
        }

        else if (direction == "E") {
            System.out.println("Go East");
        }

        else if (direction == "W") {
            System.out.println("Go West");
        }

        return room; 
 
    }

    /* you may wish to add some helper methods*/
}