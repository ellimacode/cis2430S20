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

    @Override
    public String toss() {

        return "You have tossed the item.\n";
    }

}