package phoneV2;

public class PhoneCase {
    private String color;
    private String material;

    public PhoneCase(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "PhoneCase {" +
                ".color='" + color + '\'' +
                " .material='" + material + '\'' +
                '}';
    }
}
