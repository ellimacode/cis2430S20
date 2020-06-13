package adventure;

public class Weapon extends Item implements Tossable {

    /**
     * constructor, passes in name and description
     * to Item class
     * @param name
     * @param description
     */
    public Weapon(String name, String description) {

        super(name, description);
    }

    
    @Override
    public String toss() {
        return "You have tossed the weapon.\n";
    }

}