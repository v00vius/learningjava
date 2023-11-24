package arrays2;

import arrays1.DynamicArray;

public class Task5 {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.fillRandom(30, 21);

        int avg = array.avg();

        System.out.println(array);
        System.out.println("Average: " + avg);

    }
}
