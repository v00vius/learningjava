package hardwareStore;

import utils.UserInterface;

public class StoreService {
    private HardwareStore store;

    public Toolz[]  newTools() {
        UserInterface ui = new UserInterface();
        int numberOfTools = ui.getInt("Number of tools: ");
        Toolz[] tools = new Toolz[numberOfTools];

        for (int i = 0; i < tools.length; i++) {
            String toolName = ui.getString("hardwareStore.Tool #" + (i + 1)  +  " name: ");
            tools[i] = new Toolz(i, toolName);
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

//            toolSets[i] = new ToolSet(name, );
        }

        return toolSets;
    }

    public HardwareStore newHardwareStore() {
        Toolz[] tools = newTools();
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
