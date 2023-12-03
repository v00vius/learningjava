import java.util.Arrays;
import java.util.Random;

public class ArrayService {
    private int[] array;

    public ArrayService(int arraySize) {
        array = new int[arraySize];
    }

    public ArrayService randomFill(int bound) {
        Random random = new Random();

        for (int i = 0; i < array.length;)
            array[i++] = random.nextInt(bound);

        return this;
    }
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    public int selectionSort() {
        return 0;
    }
    public int bubbleSort() {
        return 0;
    }
    public int insertionSort() {
        int lastSorted = 0;
        int iterations = 0;

        while(lastSorted < array.length - 1) {
            int indexOfMin = lastSorted;

            for (int i = lastSorted + 1; i < array.length; ++i, ++iterations) {
                if(array[indexOfMin] > array[i])
                    indexOfMin = i;
            }

            if(indexOfMin != lastSorted) {
                int tmp = array[lastSorted];
                array[lastSorted] = array[indexOfMin];
                array[indexOfMin] = tmp;
            }

            ++lastSorted;
        }

        return iterations;
    }
}
