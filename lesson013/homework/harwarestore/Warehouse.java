package harwarestore;

public class Warehouse {
    private String name;
    private InstrumentInventory instruments;
    private InstrumentKitInventory kits;

    public Warehouse(String name) {
        this.name = name;
        instruments = new InstrumentInventory();
        kits = new InstrumentKitInventory();
    }

    public String getName() {
        return name;
    }

    public void append(Instrument tool) {
        instruments.append(tool);
    }
    public void append(InstrumentKit kit) {
        kits.append(kit);
    }

    public Instrument findInstrumentByName(String name) {
        return instruments.findByName(name);
    }
    public InstrumentKit findKitByName(String name) {
        return kits.findByName(name);
    }
    @Override
    public String toString() {
        return "Warehouse '" + name + "': instruments and kits\n"
            + instruments + "\n" + kits;
    }
}
