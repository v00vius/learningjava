package ui;

import dto.Response;
import entity.Client;

import service.ClientService;

import util.ConsoleIO;

public class FindClientByNameMenu implements MenuCommand {

    private final ClientService service;

    public FindClientByNameMenu(ClientService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {

        ConsoleIO userInput = new ConsoleIO();
        String nameSearch = userInput.gets("Please enter client name: ");

        Response<Client> response = service.findByName(nameSearch);

        if (response.isSuccess()) {
            System.out.println(response.getData());
        } else {
            System.out.println(response.getMessage());
        }
    }

    @Override
    public String getMenuName() {
        return "Find client by name";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
