import utils.Utils;

import java.util.Random;

public class Array2 {
    static
    public void randomFill(DynamicArray data, int range) {
        Random rnd = new Random();

        for (int i = 0; i < data.getSize();)
            data.set(i++, rnd.nextInt(range));
    }
    static
    public DynamicArray getArrayOfMax(DynamicArray data) {
        DynamicArray array = new DynamicArray(0);

    }

    public static void main(String[] args) {

    }
}
