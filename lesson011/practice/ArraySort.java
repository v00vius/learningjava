import java.util.Arrays;

public class ArraySort {
    public int  bubbleSort(int[] workingArray){
        int iterations = 0;
        boolean notSorted = true;
        int temp;

        // {1,2,3,4,5,6,7,8} - если мы меняем хотя бы одну пару -
        // то это означает что наш массив все еще не отсортирован
        int endIndex = workingArray.length - 1;

        while (notSorted) {
//            System.out.println(notSorted);
//            System.out.println(Arrays.toString(workingArray));
            notSorted = false;
            ++iterations;

//            System.out.println(endIndex);

            for (int i = 0; i < endIndex; ++i) {
                if (workingArray[i] > workingArray[i + 1]) {
                    temp = workingArray[i];
                    workingArray[i] = workingArray[i + 1];
                    workingArray[i + 1] = temp;
                    notSorted = true;
//                    System.out.println(Arrays.toString(workingArray));
                }
            }

            --endIndex;
        }

        return iterations;
    }
}
