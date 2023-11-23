import utils.UserInterface;
import utils.Utils;

import java.util.Random;

public class Array2 {
    static
    public DynamicArray fillRandom(DynamicArray data, int nElements, int range) {
        Random rnd = new Random();

        for (int i = 0; i < nElements;)
            data.set(i++, rnd.nextInt(range));

        return data;
    }
    static
    public DynamicArray getArrayOfMax(DynamicArray data) {
        DynamicArray array = new DynamicArray(0);

        int max = Integer.MIN_VALUE;
        int index;

        //
        // Pass 1
        // Find the maximum max and its index
        for (int i = 0; i < data.getSize(); i++) {
            if(data.get(i) >  max) {
                max = data.get(i);
                index = i;
            }
        }

        //
        // Pass 2
        // copy indexes of maximums to max array
        DynamicArray maxArray = new DynamicArray();

        for (int i = 0, count = 0; i < data.getSize(); i++) {
            if(data.get(i) == max)
                maxArray.set(count++, i);
        }

        return maxArray;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        DynamicArray array1 = new DynamicArray();
        System.out.println("Created an empty array: " + array1);

        int n = ui.getInt("Enter the array size: ");

        if(n < 2)
            Utils.fatalExit("Array size should be > 1 (entered: " + n + ")");

        System.out.println("--- --- ---\nA random array:");
        System.out.println(fillRandom(array1, n, 101));

        DynamicArray indexOfMax = getArrayOfMax(array1);
        System.out.println("[1]An array of indexes of max elements:");
        System.out.println(indexOfMax);

        array1 = new DynamicArray(new int[] {2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5});
        System.out.println("--- --- ---\n" + array1);
        indexOfMax = getArrayOfMax(array1);

        System.out.println("[2]An array of indexes of max elements:");
        System.out.println(indexOfMax);
    }
}
