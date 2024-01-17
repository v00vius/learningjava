package arrays2;

import arrays1.DynamicArray;

public class Task1 {
        public static void main(String[] args)
        {
                DynamicArray array = new DynamicArray();
                array.fillRandom(9, 21);

                System.out.println(array + "\nReverse:\n" + array.reverse());

        }
}
