import java.util.Random;

public class Task15_5 {
    public void randomFill(ArrayInt array, int lowBound, int highBound ) {
        int[] data = array.getData();
        Random rnd = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rnd.nextInt(lowBound, highBound +1);
        }
    }

    public Pair findMax(ArrayInt array) {
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

    public void transform(ArrayInt array) {
        int[] data = array.getData();

        for (int i = 1; i < data.length; i += 2) {
            data[i] = 0;
        }
    }
    public void print(ArrayInt array) {
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
        ArrayInt array = new ArrayInt(12);
        Task15_5 task = new Task15_5();
//
//      Task15_5
        System.out.println("Initial array:");
        task.randomFill(array, -15, +15);
        task.print(array);

        Pair maxInfo = task.findMax(array);

        System.out.println("Max element " + maxInfo.first + ", index " + maxInfo.second);

//
//      Task15_6
        array = new ArrayInt(8);
        task.randomFill(array, 1, 10);
        System.out.println("\n\nInitial array:");
        task.print(array);

        task.transform(array);
        System.out.println("After transform:");
        task.print(array);
    }
}
