import java.util.Random;

public class Task15_5 {
    public void randomFill(Array12 array, int lowBound, int highBound ) {
        int[] data = array.getData();
        Random rnd = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rnd.nextInt(lowBound, highBound +1);
        }
    }

    public Pair findMax(Array12 array) {
        int[] data = array.getData();

        int indexMax = 0;
        int max = data[indexMax];

        for (int i = indexMax + 1; i < data.length; i++) {
            if(data[i] > max) {
                indexMax = i;
                max = data[indexMax];
            }
        }

        return new Pair(max, indexMax);
    }
    public void print(Array12 array) {
        int[] data = array.getData();

        for (int i = 0; i < data.length; i++) {
            if(i == 0)
                System.out.print("{" + data[i]);
            else
                System.out.print(", " + data[i]);
        }

        System.out.println("}");
    }

    public static void main(String[] args) {
        Array12 array = new Array12();
        Task15_5 task = new Task15_5();

        System.out.println("Initial array:");
        task.randomFill(array, -15, +15);
        task.print(array);

        Pair maxInfo = task.findMax(array);

        System.out.println("Max element " + maxInfo.first + ", index " + maxInfo.second);
    }
}
