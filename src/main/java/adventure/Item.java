package adventure;


public class Item{
    /* you will need to add some private member variables */

    private String itemName;
    private String description;
    private Room room;
    private Integer ID;

    public Item(String name, String info) {
        itemName = name;
        description = info;

    }

    public Item(Integer tag, String name, String info) {
        ID = tag;
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

    public Integer getID() {

        return ID;
    }

    /**
     * @return item's description
     */
    public String getLongDescription(){

        return description;
    }

    public Room getContainingRoom(){
        //returns a reference to the room that contains the item
        return room;
    }

    /* you may wish to add some helper methods*/


    public void setContainingRoom(Room r){

        room = r;
    }
    

    @Override
    public String toString() {
        return itemName + "\n" + description + "\n";
    }
}
