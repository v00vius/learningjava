package hardwareStore;

public class ToolSet {
    private String name;
    private Tool tool1;
    private Tool tool2;

    public ToolSet(String name, Tool tool1, Tool tool2) {
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
