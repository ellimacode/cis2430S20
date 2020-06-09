package adventure;

public class Spell extends Item implements Readable {

    public Spell(String spell, String type) {

        super(spell, type);
    }

    @Override
    public String read() {

        return "Spell is readable.\n";
    }

}