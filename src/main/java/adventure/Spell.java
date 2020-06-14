
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

    /**
     * implements Readable interface method read()
     * @return String 
     */
    @Override
    public String read() {

        return "Labelled 'DO NOT DRINK'.\n";
    }

}

