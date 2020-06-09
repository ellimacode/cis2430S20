package adventure; 

public class Food extends Item implements Edible {

    /**
     * constructor, passes params to super class Item
     * @param food
     * @param type
     */
    public Food(String food, String type) {
        super(food, type);
    }

    @Override
    public String eat() {
        return "Food Item is edible.\n";
    }
	
	
}
