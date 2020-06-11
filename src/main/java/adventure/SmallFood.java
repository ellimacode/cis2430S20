package adventure;

public class SmallFood extends Food implements Tossable {

    /**
     * constructor, passes params to super class Food
     * @param smallFood
     * @param type
     */
    public SmallFood(String smallFood, String type) {

        super(smallFood, type);
    }

    @Override
    public String toss() {

        return "You can toss the item.\n";
    }

}