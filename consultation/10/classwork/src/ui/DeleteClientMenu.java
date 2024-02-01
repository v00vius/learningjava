package ui;

import dto.Response;
import entity.Client;

import service.ClientService;
import util.ConsoleIO;


public class DeleteClientMenu implements MenuCommand {

    private final ClientService service;

    public DeleteClientMenu(ClientService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {

        ConsoleIO userInput = new ConsoleIO();
        int idSearch = userInput.getInt("Please enter client id: ");


        Response< Boolean> response = service.delete(idSearch);
        if (response.getMessage().equals("Ok")) {
            System.out.println(response.getData());
        } else {
            System.out.println(response.getMessage());
        }
    }

    @Override
    public String getMenuName() {
        return "Delete client";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
