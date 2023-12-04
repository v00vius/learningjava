package hardwareStore;

public class Toolz {
    private int id;
    private String name;

    public Toolz(int id, String name) {
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
