package adventure;

public class Spell extends Item implements Readable {

    /**
     * constructor, passes in name and description
     * to Item class (super class)
     * @param name
     * @param description
     */
    public Spell(String name, String description) {

        super(name, description);
    }

    @Override
    public String read() {

        return "You can read the spell.\n";
    }

}