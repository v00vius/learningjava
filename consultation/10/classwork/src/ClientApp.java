import repository.ClientDatabase;
import service.ClientService;
import ui.*;

import java.util.ArrayList;
import java.util.List;

public class ClientApp {
    public static void main(String[] args) {
        ClientDatabase database = new ClientDatabase();
        ClientService service = new ClientService(database);

        AddClientMenu addClientMenu = new AddClientMenu(service);
        FindAllClientMenu findAllClientMenu = new FindAllClientMenu(service);
        FindByIdClientMenu findByIdClientMenu = new FindByIdClientMenu(service);
        FindClientByNameMenu findClientByNameMenu = new FindClientByNameMenu(service);
        DeleteClientMenu deleteClientMenu = new DeleteClientMenu(service);
        ExitMenu exitMenu = new ExitMenu();

        List<MenuCommand> menuCommands = new ArrayList<>();
        menuCommands.add(addClientMenu);
        menuCommands.add(findAllClientMenu);
        menuCommands.add(findByIdClientMenu);
        menuCommands.add(findClientByNameMenu);
        menuCommands.add(deleteClientMenu);
        menuCommands.add(exitMenu);

        UserMenu userMenu = new UserMenu(menuCommands);
        userMenu.startUserMenu();


    }
}
