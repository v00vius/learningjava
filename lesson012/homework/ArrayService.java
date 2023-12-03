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

        return array;
    }
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    public int selectionSort() {

    }
    public int bubbleSort() {

    }
    public int insertionSort() {

    }
}
