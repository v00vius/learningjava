package arrays2;

import arrays1.DynamicArray;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    static
    public int mostFrequentlyUsed(DynamicArray array) {
        DynamicArray element = new DynamicArray();
        DynamicArray refCount = new DynamicArray();
        boolean[] elementUsed = new boolean[array.getSize()];

        for(int i = 0; i < array.getSize() - 1; ++i) {
            int elem = array.get(i);

            elementUsed[i] = true;
            element.add(elem);
            refCount.add(1);

            for (int j = i + 1; j < array.getSize(); ++j) {
                if(elementUsed[j])
                    continue;

                if(elem == array.get(j)) {
                    elementUsed[j] = true;
                    refCount.inc(refCount.getSize() - 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < element.getSize(); ++i) {
            if(refCount.get(i) > max) {
                index = i;
                max = refCount.get(i);
            }
        }

/*
        System.out.println("elements");
        System.out.println(element);

        System.out.println("ref count");
        System.out.println(refCount);
*/

        return element.get(index);
    }
    static
    public DynamicArray fillRandom(DynamicArray data, int nElements, int range) {
        Random rnd = new Random();

        for (int i = 0; i < nElements;)
            data.set(i++, rnd.nextInt(range));

        return data;
    }


    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        fillRandom(array, 30, 11);

        int frequentlyUsed = mostFrequentlyUsed(array);

        System.out.println(array);
        System.out.println(frequentlyUsed);
    }
}
