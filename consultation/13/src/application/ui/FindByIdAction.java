package application.ui;

import application.core.dto.AddToDoRequest;
import application.service.AddToDoService;
import application.service.FindByIdService;
import utils.UserInterface;

public class FindByIdAction implements UIAction {
private final FindByIdService service;

UserInterface userInput = new UserInterface();

public FindByIdAction(FindByIdService service)
{
        this.service = service;
}

@Override
public void execute()
{
        var id = userInput.getInt("Enter a user ID: ");
        var request = new AddToDoRequest(id);
        var response = service.find(request);

        System.out.println("Received response: " + response);

}

@Override
public String getActionName()
{
        return "Find a user by his/her ID";
}
}
