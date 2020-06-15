package adventure;


public class Item implements java.io.Serializable {
    /* you will need to add some private member variables */

    private String itemName;
    private String description;
    private Room room;
    private Integer id;

    private static final long serialVersionUID = -3788086098781612036L;

    /**
     * initialize connected room
     */
    public Item() {
        room = new Room();
    }

    /**
     * constructor, initialize name and description
     * @param name
     * @param info
     */
    public Item(String name, String info) {
        itemName = name;
        description = info;

    }

    /**
     * constructor, initialize tag,name and description
     * @param tag
     * @param name
     * @param info
     */
    public Item(Integer tag, String name, String info) {
        id = tag;
        itemName = name;
        description = info;

    }

    /**
     * set the name to item's name
     * @param name
     */
    public void setItemName(String name) {

        itemName = name;
    }

    /**
     * get the item's name
     * @return itemName
     */
    public String getName(){

        return itemName;
    }

    /**
     * set the id to num
     * @param num
     */
    public void setId(Integer num) {

        id = num;
    }

    /**
     * get the id of item
     * @return id
     */
    public Integer getId() {

        return id;
    }

    /**
     * set the item's description
     * @param info
     */
    public void setDescription(String info) {

        description = info;
    }


    /**
     * get long description of item
     * @return description
     */
    public String getLongDescription(){

        return description;
    }

    /**
     * returns a reference to the room that contans the item
     * @return room 
     */
    public Room getContainingRoom(){

        return room;
    }

    /* you may wish to add some helper methods*/


    /**
     * set contained room
     * @param containedRoom
     */
    public void setContainingRoom(Room containedRoom){

        room = containedRoom;
    }


    /**
     * format string for item
     * @return
     */
    @Override
    public String toString() {

        return "NAME: " + itemName + ", " + "DESCRIPTION: " + description + "\n";
    }
}
