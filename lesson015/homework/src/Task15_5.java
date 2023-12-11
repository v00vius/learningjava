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
    public int average(ArrayInt array) {
        int[] data = array.getData();
        double avg = 0.0;

        for (int i = 0; i < data.length; ++i) {
            avg += data[i];
        }

        return (int) (avg / data.length);
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

//
//      Task15_7
        array = new ArrayInt(5);
        task.randomFill(array, 0, 5);
        System.out.println("\n\nInitial array1:");
        task.print(array);

        ArrayInt array1 = new ArrayInt(5);
        task.randomFill(array1, 0, 5);
        System.out.println("Initial array2:");
        task.print(array1);

        int avg = task.average(array);
        int avg1 = task.average(array1);

        System.out.println("Average of array1 (avg1): " + avg);
        System.out.println("Average of array2 (avg2): " + avg1);

        if(avg < avg1)
            System.out.println("avg1 < avg2");
        else if(avg == avg1)
            System.out.println("avg1 == avg2");
        else
            System.out.println("avg1 > avg2");

        System.out.println("Bye!");

    }
}
