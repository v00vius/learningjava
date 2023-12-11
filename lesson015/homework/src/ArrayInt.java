import java.util.Arrays;

public class ArrayInt {
    private int[] data;

    public ArrayInt(int size) {
        data = new int[size];
    }
    public ArrayInt(int[] from, int size) {
        data = new int[size];

        for (int i = 0; i < data.length; i++) {
            data[i] = from[i];
        }
    }

    public int[] getData() {
        return data;
    }
    public int getSize() {
        return data.length;
    }
}
