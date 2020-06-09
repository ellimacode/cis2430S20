package adventure;

public class BrandedClothing extends Clothing implements Readable {

    public BrandedClothing(String brand, String label) {
        super(brand, label);
    }

    @Override
    public String read() {
        return "BrandedClothing is readable.\n";
    }

}