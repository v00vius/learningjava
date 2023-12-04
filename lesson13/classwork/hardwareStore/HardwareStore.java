package hardwareStore;

import java.util.Arrays;

public class HardwareStore {
    private String name;
    private ToolSet[] toolSets;
    private Toolz[] tools;

    public HardwareStore(String name, ToolSet[] toolSets, Toolz[] tools) {
        this.name = name;
        this.toolSets = toolSets;
        this.tools = tools;
    }

    @Override
    public String toString() {
        return "hardwareStore.HardwareStore{" +
                "name='" + name + '\'' +
                ", toolSets=" + Arrays.toString(toolSets) +
                ", tools=" + Arrays.toString(tools) +
                '}';
    }
}
