package task3;

public class Item {
        public Item(String name, int price)
        {
                this.name = name;
                this.price = price;
        }

        public void print()
        {
                System.out.printf("Item name: %s, %d rouble(s)\n", name, price);
        }


        String name;
        int price;
}
