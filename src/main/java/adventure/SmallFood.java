package adventure;

public class SmallFood extends Food implements Tossable {

    /**
     * constructor, passes params to super class Food
     * @param name
     * @param description
     */
    public SmallFood(String name, String description) {

        super(name, description);
    }

    /**
     * implements Tossable interface method toss()
     * @return String 
     */
    @Override
    public String toss() {

        return "Tossed.\n";
    }

}


