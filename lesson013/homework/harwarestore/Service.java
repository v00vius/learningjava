package harwarestore;

import utils.UserInterface;

public class Service {
    private Warehouse store;
    private UserInterface ui;

    public Service(Warehouse store) {
        this.store = store;
        ui = new UserInterface();
    }

    public void loadWarehouse() {
        while(true) {
            ui.message(store + "\n");
            ui.message("Warehouse '" + store.getName() + "'\n");
            ui.message("  1) load an instrument to the warehouse\n");
            ui.message("  2) load a kit to the warehouse\n");
            String action = ui.getString("Enter the number (<enter> to exit): \n");

            if(action.isEmpty())
                break;

            if(action.equals("1"))
                loadInstrument();
            else if(action.equals("2"))
                loadKit();
            else
                ui.message("Invalid action!\n");
        }
    }

    public void loadInstrument() {
        String instrumentName = ui.getString("Enter a new instrument name:");

        if(instrumentName.isEmpty()) {
            ui.message("Operation canceled!\n");
            return;
        }

        Instrument tool = store.findInstrumentByName(instrumentName);

        if(tool != null) {
            ui.message("Instrument '" + instrumentName + "' already exists\n");
            return;
        }

        tool = new Instrument(instrumentName);
        ui.message("You entered:\n" + tool + "\n");
        store.append(tool);
    }

    public void loadKit() {
        ui.message("Not implemented yet!\n");

        String kitName = ui.getString("Enter a new kit name:");

        if(kitName.isEmpty()) {
            ui.message("Operation canceled!\n");
            return;
        }

        String instrument1Name = ui.getString("Enter the first (existing in the warehouse) instrument name:");
        String instrument2Name = ui.getString("Enter the second (existing in the warehouse) instrument name:");
        Instrument tool1 = store.findInstrumentByName(instrument1Name);
        Instrument tool2 = store.findInstrumentByName(instrument2Name);
    }
}
