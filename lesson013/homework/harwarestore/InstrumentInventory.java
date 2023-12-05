package harwarestore;

import java.util.Arrays;

public class InstrumentInventory {
    private int maxAvailableItems = 10;
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
        String line = "Instrument inventory: " + availableItems + " items available";

        for (int i = 0; i < availableItems; ++i) {
            line += "\n  " + (i + 1) + ") " + instruments[i];
        }

        return line;
    }
}
