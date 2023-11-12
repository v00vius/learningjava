package task3;

public class Task3Test {
    public static void main(String[] args) {
        Item backpack = new Item("Backpack", 1000);
        Item rainCover = new Item("Rain cover", 500);

        backpack.print();
        rainCover.print();

        int discount = 100;

        int total = backpack.price + rainCover.price - discount;

        System.out.printf("--- Total %d roubles (including %d discount)\n", total, discount);
    }
}
