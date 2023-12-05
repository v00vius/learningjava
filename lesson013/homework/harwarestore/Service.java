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
            ui.message("*** [Warehouse '" + store.getName() + "'] ***\n");
            ui.message(store + "\n");

            int choice = ui.menuChoice(new String[] {
                    "Load an instrument into the warehouse",
                    "Load a kit into the warehouse"
            });

            if(choice == 0)
                break;

            if(choice == 1)
                loadInstrument();
            else if(choice == 2)
                loadKit();
        }

        ui.message("Bye!\n");
    }

    public void loadInstrument() {
        String instrumentName = ui.getString("Give the name of the new instrument: ");

        if(instrumentName.isEmpty()) {
            ui.message("Operation canceled!\n");
            return;
        }

        Instrument tool = store.findInstrumentByName(instrumentName);

        if(tool != null) {
            ui.message("Instrument '" + instrumentName + "' already exists in the Warehouse.\n");
            return;
        }

        tool = new Instrument(instrumentName);
        ui.message("You've entered the new instrument '" + tool + "'\n");
        store.append(tool);
    }

    public void loadKit() {
        String kitName = ui.getString("Give the name of the new Kit: ");

        if(kitName.isEmpty()) {
            ui.message("Operation canceled!\n");
            return;
        }

        String instrument1Name = ui.getString("Give the name of the first (existing in the warehouse) instrument: ");
        Instrument tool1 = store.findInstrumentByName(instrument1Name);

        if(tool1 == null) {
            ui.message("Instrument '" + instrument1Name + "' doesn't exist in the Warehouse.\n");
            return;
        }

        String instrument2Name = ui.getString("Give the name of the second (existing in the warehouse) instrument: ");
        Instrument tool2 = store.findInstrumentByName(instrument2Name);

        if(tool2 == null) {
            ui.message("Instrument '" + instrument2Name + "' doesn't exist in the Warehouse.\n");
            return;
        }

        InstrumentKit kit = new InstrumentKit(kitName, tool1, tool2);
        ui.message("You've entered the new Kit: " + kit + "\n");
        store.append(kit);
    }
}
