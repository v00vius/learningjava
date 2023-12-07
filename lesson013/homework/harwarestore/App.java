package harwarestore;

public class App {
    
    public static void main(String[] args) {
        Warehouse store = new Warehouse("Hardware store");

        Instrument tool1 = new Instrument("Axe");
        Instrument tool2 = new Instrument("Hammer");

        store.append(tool1);
        store.append(tool2);

        InstrumentKit kit1 = new InstrumentKit("Kit A", tool1, tool2);
        store.append(kit1);

        tool1 = new Instrument("Handsaw");
        tool2 = new Instrument("Combination pliers");

        store.append(tool1);
        store.append(tool2);

        InstrumentKit  kit2 = new InstrumentKit("Kit B", tool1, tool2);
        store.append(kit2);

        WarehouseService service = new WarehouseService(store);
        service.loadWarehouse();
    }
}
