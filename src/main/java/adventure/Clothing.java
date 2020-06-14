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

    /**
     * implements Wearable interface method wear()
     * @return String
     */
    @Override
    public String wear() {
        return "Worn.\n";
    }

}

