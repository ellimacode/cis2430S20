package adventure;

public class BrandedClothing extends Clothing implements Readable {

    private String brand;

    /**
     * constructor, passes name and description
     * to Item (super class)
     * @param name
     * @param description
     */
    public BrandedClothing(String name, String description) {

        super(name, description);
    }

    /**
     * implements Readable interface method
     * @return String 
     */
    @Override
    public String read() {

        return brand;
    }

}

