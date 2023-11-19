package task1;

public class Grocery {
    private String name;
    private boolean isOpen;

    public Grocery(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public boolean open() {
        boolean prevState = isOpen;

        isOpen = true;

        return prevState;
    }

    public boolean close() {
        boolean prevState = isOpen;

        isOpen = false;

        return prevState;

    }

    @Override
    public String toString() {
        return "Grocery \"" + name.toString() + "\"" + (isOpen ? ": open" : ": closed" );
    }

    public static void main(String[] args) {
        Grocery edeka = new Grocery("Edeka");
        Grocery rewe = new Grocery("Rewe");

        System.out.println(edeka);
        System.out.println(rewe);

        edeka.open();
        rewe.close();

        boolean isEdekaOpen = edeka.isOpen();
        boolean isReweOpen = rewe.isOpen();
        boolean canBuy = isEdekaOpen || isEdekaOpen;

        System.out.println(edeka);
        System.out.println(rewe);

        System.out.println("Can I buy? " + canBuy);
    }
}
