package harwarestore;

import utils.Menu;
import utils.UserInterface;

public class WarehouseService {
        private Warehouse store;
        private UserInterface userInterface;

        public WarehouseService(Warehouse store)
        {
                this.store = store;
                userInterface = new UserInterface();
        }

        public void loadWarehouse()
        {
                Menu menu = new Menu("Warehouse");

                menu.add(new String[]{
                                "Load an instrument into the warehouse",
                                "Load a kit into the warehouse",
                                "Show the warehouse items"
                        }
                );

                while (true) {
                        int choice = menu.show().select();

                        if (choice == 0) {
                                break;
                        }

                        if (choice == 1) {
                                loadInstrument();
                        } else if (choice == 2) {
                                loadKit();
                        } else if (choice == 3) {
                                userInterface.message(store + "\n");
                        }
                }

                userInterface.message("Bye!\n");
        }

        public void loadInstrument()
        {
                String instrumentName = userInterface.getString("Give the name of the new instrument: ");

                if (instrumentName.isEmpty()) {
                        userInterface.message("Operation canceled!\n");
                        return;
                }

                Instrument tool = store.findInstrumentByName(instrumentName);

                if (tool != null) {
                        userInterface.message("Instrument '" + instrumentName + "' already exists in the Warehouse.\n");
                        return;
                }

                tool = new Instrument(instrumentName);
                userInterface.message("You've entered the new instrument '" + tool + "'\n");
                store.append(tool);
        }

        public void loadKit()
        {
                String kitName = userInterface.getString("Give the name of the new Kit: ");

                if (kitName.isEmpty()) {
                        userInterface.message("Operation canceled!\n");
                        return;
                }

                String instrument1Name = userInterface.getString("Give the name of the first (existing in the warehouse) instrument: ");
                Instrument tool1 = store.findInstrumentByName(instrument1Name);

                if (tool1 == null) {
                        userInterface.message("Instrument '" + instrument1Name + "' doesn't exist in the Warehouse.\n");
                        return;
                }

                String instrument2Name = userInterface.getString("Give the name of the second (existing in the warehouse) instrument: ");
                Instrument tool2 = store.findInstrumentByName(instrument2Name);

                if (tool2 == null) {
                        userInterface.message("Instrument '" + instrument2Name + "' doesn't exist in the Warehouse.\n");
                        return;
                }

                InstrumentKit kit = new InstrumentKit(kitName, tool1, tool2);
                userInterface.message("You've entered the new Kit: " + kit + "\n");
                store.append(kit);
        }
}
