package hardwareStore;

public class ToolSet {
    private String name;
    private Toolz tool1;
    private Toolz tool2;

    public ToolSet(String name, Toolz tool1, Toolz tool2) {
        this.name = name;
        this.tool1 = tool1;
        this.tool2 = tool2;
    }

    @Override
    public String toString() {
        return "hardwareStore.ToolSet{" +
                "name='" + name + '\'' +
                ", tool1=" + tool1 +
                ", tool2=" + tool2 +
                '}';
    }
}
