package adventure; 

public class Food extends Item implements Edible {

    /**
     * constructor, passes params to super class Item
     * @param name
     * @param description
     */
    public Food(String name, String description) {

        super(name, description);
    }

    @Override
    public String eat() {

        return "You have eaten the item.\n";
    }
	
	
}
