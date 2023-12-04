package hardwareStore;

import java.util.Arrays;

public class HardwareStore {
    private String name;
    private ToolSet[] toolSets;
    private Toolz[] tools;

    public HardwareStore(String name) {
        this.name = name;
        this.toolSets = new ToolSet[Config.maxToolSets];
        this.tools = new Toolz[Config.maxTools];
    }

    public int newTool(String name) {

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
