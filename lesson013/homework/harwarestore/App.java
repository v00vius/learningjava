package harwarestore;

public class App {
    public static void main(String[] args) {
        InstrumentInventory toolInventory = new InstrumentInventory();
        Instrument tool1 = new Instrument("Axe");
        Instrument tool2 = new Instrument("Hammer");

        toolInventory.append(tool1);
        toolInventory.append(tool2);
        InstrumentKit kit1 = new InstrumentKit("testA", tool1, tool2);
        System.out.println(kit1);
//        System.out.println(toolInventory);

        tool1 = new Instrument("Handsaw");
        tool2 = new Instrument("Combination pliers");

        toolInventory.append(tool1);
        toolInventory.append(tool2);
        InstrumentKit  kit2 = new InstrumentKit("testB", tool1, tool2);
        System.out.println(kit2);
        System.out.println(toolInventory);
    }
}
