package adventure;

import java.util.ArrayList;

public class Adventure implements java.io.Serializable {
    /* you will need to add some private member variables */
    private Room currentRoom;
    private Item currentItem;
    private String description;
    private ArrayList<Room> rooms;
    private ArrayList<Item> items;
    private static final long serialVersionUID = -3788086098781612036L;

    public Adventure(ArrayList<Room> listofRooms, ArrayList<Item> listofItems) {
        rooms = listofRooms;
        items = listofItems;
    }

    /* ======== Required public methods ========== */
        /* note,  you don't have to USE all of these
        methods but you do have to provide them.
        We will be using them to test your code */

    /**
     * get the list of rooms
     * @return rooms
     */
    public ArrayList<Room> listAllRooms(){
        return rooms;
    }

    /**
     * get the list of items
     * @return items
     */
    public ArrayList<Item> listAllItems(){
        return items;
    }

    /**
     * get the current room's description
     * @return description
     */
    public String getCurrentRoomDescription(){
        return description;
    }


    /**
     * get the current room
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * set the current room
     * @param room
     */
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }


    /**
     * process quit command
     * @param toQuit
     */
    public void quitPlayer(Command toQuit) {
        System.out.println("You are quitting the game.");
    }

    /**
     * print out helpful commands to user
     */
    public void helpPlayer() {
        System.out.println("\n-------HELPFUL COMMANDS-------\n");
        System.out.println("go (direction) - to go in the direction (N/S/E/W/up/down)");
        System.out.println("look (itemName) - to see description of item");
        System.out.println("look - to see description of current room");
        System.out.println("take (itemName) - to pick up item");
        System.out.println("inventory - to see current inventory");
        System.out.println("quit - quit game\n");
    }

    /**
     * allows player to move
     * @param toGo
     */
    public void goPlayer(Command toGo) {
        if (!toGo.hasSecondWord()) {
            System.out.println("Go where?\n");
            return;
        } else {
            String direct = toGo.getNoun();

            if (toGo.isValid(direct)) {
                Room nextRoom = currentRoom.getConnectedRoom(direct);

                if (nextRoom != null) {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                } else {
                    System.out.println("No Exit.\n");
                }
            } else {
                System.out.println("Go where?\n");
                return;
            }
        }
    }

    /**
     * allows player to look at items
     * @param lookThing
     */
    public void lookItem(Command lookThing) {
        String thing = lookThing.getNoun();

        if (thing.equals("lamp")) {
            currentItem = currentRoom.getItem(0);
        } else if (thing.equals("wand")) {
            currentItem = currentRoom.getItem(0);
        } else if (thing.equals("potion")) {
            currentItem = currentRoom.getItem(1);
        } else {
            System.out.println("No item exist.\n");
        }

        System.out.println(currentItem.getLongDescription() + "\n");

    }

    /**
     * allows player to look at room description
     */
    public void lookPlayer() {
        System.out.println(currentRoom.getLongDescription() + "\n");
    }

    /**
     * format string form of adventure class
     * @return rooms, items
     */
    @Override
    public String toString() {
        return "Rooms: " + rooms + "\n"
                + "Items: " + items + "\n";
    }
}
