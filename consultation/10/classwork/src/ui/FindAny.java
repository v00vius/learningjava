package ui;

import dto.Response;
import entity.Client;
import service.ClientService;
import util.ConsoleIO;

import java.util.List;

public class FindAny implements MenuCommand {

    private final ClientService service;

    public FindAny(ClientService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {
        ConsoleIO userInput = new ConsoleIO();
        String toSearch = userInput.gets("Please enter the text to search: ");

        Response<Client> response = service.findAny(toSearch);

        if (response.isSuccess()) {
            System.out.println(response.getData());
        } else {
            System.out.println(response.getMessage());
        }
    }

    @Override
    public String getMenuName() {
        return "Free text search";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
