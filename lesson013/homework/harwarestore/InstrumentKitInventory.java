package harwarestore;

public class InstrumentKitInventory {
    private int maxAvailableItems = 10;
    private int availableItems;
    private InstrumentKit[] instrumentKits;
    public InstrumentKitInventory() {
        availableItems = 0;
        instrumentKits = new InstrumentKit[maxAvailableItems];
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void append(InstrumentKit kit) {
        instrumentKits[availableItems] = kit;
        ++availableItems;
    }

    @Override
    public String toString() {
        String line = "Instrument kit inventory: " + getAvailableItems() + " kits available";

        for (int i = 0; i < getAvailableItems(); i++) {
            line += "\n" + (i + 1) + ") " + instrumentKits[i];
        }

        return line;
    }
}
