package arrays2;

import arrays1.DynamicArray;

public class Task2 {
        public static void main(String[] args)
        {
                DynamicArray array1 = new DynamicArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});

                System.out.println(array1);
                System.out.println("Unique?" + array1.isUnique());

                DynamicArray array2 = new DynamicArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1});

                System.out.println(array2);
                System.out.println("Unique?" + array2.isUnique());
        }
}
