package adventure;

public class Clothing extends Item implements Wearable {

    public Clothing(String clothes, String desc) {

        super(clothes, desc);
    }

    @Override
    public String wear() {

        return "Clothing is wearable.\n";
    }

}