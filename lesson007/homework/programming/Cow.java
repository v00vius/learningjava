package programming;

import java.util.Random;

public class Cow {
    private int total;

    public Cow(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String word = "";

        switch(total % 10) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                word = "коров";
                break;

            case 1:
                word = "корова";
                break;

            case 2:
            case 3:
            case 4:
                word = "коровы";
        }

        return "На лугу пасется " + total + " " + word;
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        for (int i = 0; i < 7; i++)
            System.out.println(new Cow(rnd.nextInt(11)));
    }
}
