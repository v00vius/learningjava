package ui;

import dto.Response;
import entity.Client;
import service.ClientService;

import java.util.List;

public class FindAllClientMenu implements MenuCommand {

    private final ClientService service;

    public FindAllClientMenu(ClientService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {

        Response<List<Client>> response = service.findAll();

        if (response.isSuccess()) {
            System.out.println(response.getData());
        } else {
            System.out.println(response.getMessage());
        }

    }

    @Override
    public String getMenuName() {
        return "Find all clients";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
