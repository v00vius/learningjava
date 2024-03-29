import java.util.Arrays;
import java.util.Random;

public class ArrayService {
        private int[] array;

        public ArrayService(int arraySize)
        {
                array = new int[arraySize];
        }

        public ArrayService(int[] array)
        {
                this.array = array;
        }

        public ArrayService randomFill(int bound)
        {
                Random random = new Random();

                for (int i = 0; i < array.length; )
                        array[i++] = random.nextInt(bound);

                return this;
        }

        @Override
        public String toString()
        {
                return Arrays.toString(array);
        }

        private void swap(int indexA, int indexB)
        {
                int tmp = array[indexA];

                array[indexA] = array[indexB];
                array[indexB] = tmp;
        }

        public int insertionSort()
        {
                int iterations = 0;

                for (int lastSorted = 0; lastSorted < array.length - 1; ++lastSorted) {
                        if (array[lastSorted] <= array[lastSorted + 1]) {
                                ++iterations;
                                continue;
                        }

                        int index = lastSorted;

                        do {
                                swap(index, index + 1);

                                if (index == 0) {
                                        break;
                                }

                                --index;
                                ++iterations;
                        }
                        while (array[index] > array[index + 1]);
                }

                return iterations;
        }

        public int bubbleSort()
        {
                int iterations = 0;

                for (int lastSorted = array.length - 1; lastSorted >= 0; --lastSorted) {
                        for (int j = 0; j < lastSorted; ++j, ++iterations) {
                                if (array[j] > array[j + 1]) {
                                        swap(j, j + 1);
                                }
                        }
                }

                return iterations;
        }

        public int selectionSort()
        {
                int lastSorted = 0;
                int iterations = 0;

                while (lastSorted < array.length - 1) {
                        int indexOfMin = lastSorted;

                        for (int i = lastSorted + 1; i < array.length; ++i, ++iterations) {
                                if (array[indexOfMin] > array[i]) {
                                        indexOfMin = i;
                                }
                        }

                        if (indexOfMin != lastSorted) {
                                swap(lastSorted, indexOfMin);
                        }

                        ++lastSorted;
                }

                return iterations;
        }
}
