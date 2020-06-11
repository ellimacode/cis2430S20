package adventure;

public class Clothing extends Item implements Wearable {

    /**
     * constructor, passes name and description
     * to super class, Item
     * @param name
     * @param description
     */
    public Clothing(String name, String description) {

        super(name, description);
    }

    @Override
    public String wear() {

        return "You can wear the item.\n";
    }

}