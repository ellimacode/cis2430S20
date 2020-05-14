package adventure;


public class Item{
    /* you will need to add some private member variables */

    private String itemName;
    private String description;
    private Room room = new Room();
    private ArrayList<Item> items = new ArrayList<>();

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
        return room.contains(itemName); //FIXME
    }

    /* you may wish to add some helper methods*/
    
}