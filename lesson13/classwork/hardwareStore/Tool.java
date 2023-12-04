package hardwareStore;

public class Tool {
    private int id;
    private String name;

    public Tool(int id, String name) {
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
