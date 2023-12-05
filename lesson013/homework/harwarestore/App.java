package harwarestore;

public class App {
    public static void main(String[] args) {
        Warehouse store = new Warehouse("Hardware store");
        System.out.println(store);

        Instrument tool1 = new Instrument("Axe");
        Instrument tool2 = new Instrument("Hammer");

        store.append(tool1);
        store.append(tool2);
        InstrumentKit kit1 = new InstrumentKit("testA", tool1, tool2);

        store.append(kit1);
        System.out.println(kit1);

        tool1 = new Instrument("Handsaw");
        tool2 = new Instrument("Combination pliers");
        store.append(tool1);
        store.append(tool2);

        InstrumentKit  kit2 = new InstrumentKit("testB", tool1, tool2);
        store.append(kit2);
        System.out.println(kit2);

        System.out.println(store);

        Service service = new Service(store);
        service.loadWarehouse();
    }
}
