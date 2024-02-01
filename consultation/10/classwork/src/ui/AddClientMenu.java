package ui;

import dto.Response;
import entity.Client;
import service.ClientService;


public class AddClientMenu implements MenuCommand {

    private final ClientService service;

    public AddClientMenu(ClientService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {

        Client newClient = service.createClient();

        Response<Client> response = service.add(newClient);
        if (response.isSuccess()) {
            System.out.println(response.getData());
        } else {
            System.out.println(response.getMessage());
        }
    }

    @Override
    public String getMenuName() {
        return "Add new client";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
