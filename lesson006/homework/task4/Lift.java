package task4;

import utils.UserInterface;

public class Lift {
    public static int liftFail = -1;
    private String name;
    private int height;

    public Lift(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Lift \"" + name + "\", max levels: " + height;
    }

    public int numberOfLifts(int floor, int stepUp, int stepDown) {
    // The lift will never reach the top floor
        if(stepUp <= stepDown)
            return liftFail;
    // go up
        int delta = stepUp - stepDown;
        int nLifts = height / delta;

        if(height % delta > 0)
            ++nLifts;

        return nLifts;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        Lift lift1 = new Lift(ui.getString("Lift name: "),
                            ui.getInt("Max levels: "));

        System.out.println(lift1);

        int attempts = lift1.numberOfLifts(0, 2, 1);

        if(attempts == Lift.liftFail)
            System.out.println("The lift is out of service!");
        else
            System.out.println("The number of lifts is: " + attempts);
    }
}
