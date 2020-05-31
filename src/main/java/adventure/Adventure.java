package adventure;

import java.util.ArrayList;

public class Adventure{
    /* you will need to add some private member variables */
    private Room currentRoom;
    private String description;
    private ArrayList<Room> rooms;
    private ArrayList<Item> items;

    public Adventure (ArrayList<Room> rooms, ArrayList<Item> items) {
        this.rooms = rooms;
        this.items = items;
    }

    /* ======== Required public methods ========== */
        /* note,  you don't have to USE all of these
        methods but you do have to provide them.
        We will be using them to test your code */

    public ArrayList<Room> listAllRooms(){

        return rooms;
    }

    public ArrayList<Item> listAllItems(){

        return items;
    }

    public String getCurrentRoomDescription(){

        return description;
    }

    /* you may wish to add additional methods*/
    public Room getCurrentRoom() {

        return currentRoom;
    }

    public void setCurrentRoom(Room room) {

        currentRoom = room;
    }

    @Override
    public String toString() {
        return "Rooms: " + rooms + "\n"
                + "Items: " + items + "\n";
    }
}
