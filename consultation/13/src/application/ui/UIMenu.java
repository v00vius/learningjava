package application.ui;

import java.util.List;
import java.util.Scanner;

public class UIMenu {
    private final List<UIAction> uiActions;

    public UIMenu(List<UIAction> uiActions) {
        this.uiActions = uiActions;
    }

    public void startUI(){
        while (true) {
            try {
                System.out.println("Please enter your choice: ");
                for (int i = 0; i < uiActions.size(); i++) {
                    var uiAction = uiActions.get(i);
                    System.out.println((i + 1) + ". " + uiAction.getActionName());
                }

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();
                uiActions.get(userInput - 1).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
