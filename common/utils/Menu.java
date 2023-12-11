package utils;

public class Menu {
    private String name;
    private UserInterface ui;

    private String[] menuItems;
    public Menu(String name) {
        this.name = name;
        ui = new UserInterface();
    }

    public Menu add(String item) {
        grow();
        menuItems[menuItems.length - 1] = item;

        return this;
    }
    public Menu add(String[] items) {
        grow(items.length);

        for (int i = 0; i < items.length; i++) {
            menuItems[menuItems.length - items.length + i] = items[i];
        }

        return this;
    }

    public Menu show() {
        ui.message(">>> " + name + " <<<\n");

        for (int i = 0; i < menuItems.length; i++) {
            ui.message("  " + (i + 1) + ") " + menuItems[i] + "\n");
        }

        return this;
    }

    public int select() {
        while(true) {
            ui.message("Please, select 1-" + menuItems.length + " or press <enter> to exit\n");

            String reply = ui.getString();

            if (reply.isEmpty())
                return 0;

            if (reply.matches("^[0-9]+$")) {
                int selection = Integer.parseInt(reply);

                if (1 <= selection && selection <= menuItems.length)
                    return selection;
            }

            ui.message("The Wrong selection. Once again, please.\n");
        }
    }
    private void grow() {
        grow(1);
    }
    private void grow(int delta) {
        if(menuItems == null) {
            menuItems = new String[delta];
            return;
        }

        String[] newItems = new String[menuItems.length + delta];

        for (int i = 0; i < menuItems.length; i++) {
            newItems[i] = menuItems[i];
        }

        menuItems = newItems;
    }
}
