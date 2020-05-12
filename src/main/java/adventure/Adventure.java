package adventure;

import java.util.ArrayList;

public class Adventure{
    /* you will need to add some private member variables */
    private Room enter;
    private String description;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Item> items = new ArrayList<Item>();

    /* ======== Required public methods ========== */
        /* note,  you don't have to USE all of these
        methods but you do have to provide them.
        We will be using them to test your code */

    public ArrayList<Room> listAllRooms(){
        return this.rooms;
        
    }

    public ArrayList<Item> listAllItems(){
        return this.items; 

    }

    public String getCurrentRoomDescription(){
        return description;

    }

    /* you may wish to add additional methods*/
}