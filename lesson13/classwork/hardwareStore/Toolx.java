package hardwareStore;

public class Toolx {
    private int id;
    private String name;

    public Toolx(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "hardwareStore.Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
