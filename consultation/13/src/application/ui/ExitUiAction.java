package application.ui;

import application.service.FindToDoService;

public class ExitUiAction implements UIAction{


    @Override
    public void execute() {
        System.out.println("Bye-bye!");
        System.exit(0);
    }

    @Override
    public String getActionName() {
        return "Exit";
    }
}
