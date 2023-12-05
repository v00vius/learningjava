package harwarestore;

import java.util.Arrays;

public class InstrumentInventory {
    private int maxAvailableItems = 20;
    private int availableItems;
    private Instrument[] instruments;
    public InstrumentInventory() {
        availableItems = 0;
        instruments = new Instrument[maxAvailableItems];
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void append(Instrument tool) {
        instruments[availableItems] = tool;
        ++availableItems;
    }

    @Override
    public String toString() {
        String line = "Instrument inventory: " + getAvailableItems() + " items available";

        for (int i = 0; i < getAvailableItems(); ++i) {
            line += "\n  " + (i + 1) + ") " + instruments[i];
        }

        return line;
    }
}
