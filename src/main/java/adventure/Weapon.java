package adventure;

public class Weapon extends Item implements Tossable {

    public Weapon(String weapon, String type) {

        super(weapon, type);
    }

    
    @Override
    public String toss() {

        return "Weapon is tossable.\n";
    }

}