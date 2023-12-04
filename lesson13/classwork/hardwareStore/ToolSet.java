package hardwareStore;

public class ToolSet {
    private String name;
    private Toolx tool1;
    private Toolx tool2;

    public ToolSet(String name, Toolx tool1, Toolx tool2) {
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
