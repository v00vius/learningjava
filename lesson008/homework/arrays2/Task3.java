package arrays2;

import arrays1.DynamicArray;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
        static
        public Triple mostFrequentlyUsed(DynamicArray array)
        {
                DynamicArray element = new DynamicArray();
                DynamicArray refCount = new DynamicArray();
                boolean[] elementUsed = new boolean[array.getSize()];

                for (int i = 0; i < array.getSize() - 1; ++i) {
                        int elem = array.get(i);

                        elementUsed[i] = true;
                        element.add(elem);
                        refCount.add(1);

                        for (int j = i + 1; j < array.getSize(); ++j) {
                                if (elementUsed[j]) {
                                        continue;
                                }

                                if (elem == array.get(j)) {
                                        elementUsed[j] = true;
                                        refCount.inc(refCount.getSize() - 1);
                                }
                        }
                }

                int max = Integer.MIN_VALUE;
                int index = -1;

                for (int i = 0; i < element.getSize(); ++i) {
                        if (refCount.get(i) > max) {
                                index = i;
                                max = refCount.get(i);
                        }
                }

                return new Triple(element.get(index), refCount.get(index), 0);
        }


        public static void main(String[] args)
        {
                DynamicArray array = new DynamicArray();
                array.fillRandom(30, 11);

                Triple frequentlyUsed = mostFrequentlyUsed(array);

                System.out.println(array);
                System.out.println("The most frequently used element: "
                                   + frequentlyUsed.getFirst() + ", usage count: "
                                   + frequentlyUsed.getSecond());
        }
}
