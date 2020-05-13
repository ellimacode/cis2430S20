package adventure;

import java.util.ArrayList;

public class Adventure{
    /* you will need to add some private member variables */
    private Room enter = new Room();
    private String description;
    private ArrayList<Room> rooms;
    private ArrayList<Item> items;

    /* ======== Required public methods ========== */
        /* note,  you don't have to USE all of these
        methods but you do have to provide them.
        We will be using them to test your code */

    public ArrayList<Room> listAllRooms(){
        rooms = new ArrayList<Room>();

        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
        return rooms; 
        
    }

    public ArrayList<Item> listAllItems(){
        items = new ArrayList<Item>();

        for (int j = 0; j < items.size(); j++) {
            System.out.println(items.get(j));
        }

        return items; 

    }

    public String getCurrentRoomDescription(){
        return description;

    }

    /* you may wish to add additional methods*/
}