package hardwareStore;

import utils.UserInterface;

import javax.tools.Tool;

public class StoreService {
    private HardwareStore store;

    public Toolx[]  newTools() {
        UserInterface ui = new UserInterface();
        int numberOfTools = ui.getInt("Number of tools: ");
        Toolx[] tools = new Toolx[numberOfTools];

        for (int i = 0; i < tools.length; i++) {
            String toolName = ui.getString("hardwareStore.Tool #" + (i + 1)  +  " name: ");
            tools[i] = new Toolx(i, toolName);
        }

        return tools;
    }

    public ToolSet[] newToolSets() {
        UserInterface ui = new UserInterface();
        int numberOfToolSets = ui.getInt("Number of tool sets: ");
        ToolSet[] toolSets = new ToolSet[numberOfToolSets];

        for (int i = 0; i < toolSets.length; i++) {
            String  name = ui.getString("hardwareStore.Tool set #" + ( i + 1) + " name: ");
            int tool1 = ui.getInt("hardwareStore.Tool #1, id: ");
            int tool2 = ui.getInt("hardwareStore.Tool #2, id: ");
        }

        return toolSets;
    }

    public HardwareStore newHardwareStore() {
        Toolx[] tools = newTools();
        ToolSet[] toolSets = newToolSets();
        UserInterface ui = new UserInterface();

        String storeName = ui.getString("Harware store name: ");
        store = new HardwareStore(storeName, toolSets, tools);

        return store;
    }

    @Override
    public String toString() {
        return "hardwareStore.StoreService{" +
                "store=" + store +
                '}';
    }
}
