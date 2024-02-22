package application.ui;

import application.core.dto.AddToDoRequest;
import application.service.AddToDoService;
import utils.UserInterface;

public class AddToDoUiAction implements UIAction{

    private final AddToDoService service;

    UserInterface userInput = new UserInterface();

    public AddToDoUiAction(AddToDoService service) {
        this.service = service;
    }


    @Override
    public void execute() {
        String name = userInput.getString("Enter task name: ");
        String description = userInput.getString("Enter task description: ");

        var request = new AddToDoRequest(name, description);
        var response = service.add(request);

        System.out.println("Received response: " + response);

    }

    @Override
    public String getActionName() {
        return "Add ToDo";
    }
}
