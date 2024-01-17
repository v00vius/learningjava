import java.util.Arrays;
import java.util.Random;

public class BubbleArraySort {
        public static int[] randomArray(int arraySize)
        {
                int[] array = new int[arraySize];
                Random random = new Random();

                for (int i = 0; i < array.length; i++) {
                        array[i] = random.nextInt(20);
                }

                return array;
        }

        public static void main(String[] args)
        {

        /*
        {8,3,5,2,1,4,7,6} - исходный массив
        {3,8,5,2,1,4,7,6} - сравниваем первые два элемента и если левый больше чем правый, то меняем их местами
        {3,5,8,2,1,4,7,6} - сравниваем вторую пару  и если левый больше чем правый, то меняем их местами
        {3,5,2,8,1,4,7,6}
        {3,5,2,1,8,4,7,6}
        {3,5,2,1,4,8,7,6}
        {3,5,2,1,4,7,8,6}
        {3,5,2,1,4,7,6,8} - самый большой элемент оказался на последнем месте
        -------------------------
        {3,5,2,1,4,7,6,8} - сравниваем первую пару - ничего не меняем
        {3,2,5,1,4,7,6,8}
        {3,2,1,5,4,7,6,8}
        {3,2,1,4,5,7,6,8}
        {3,2,1,4,5,7,6,8} - 5 и 7 менять местами не надо
        {3,2,1,4,5,6,7,8}
        ------------------
        {3,2,1,4,5,6,7,8}
        {2,3,1,4,5,6,7,8}
        {2,1,3,4,5,6,7,8}
        -----------------
        {2,1,3,4,5,6,7,8}
        {1,2,3,4,5,6,7,8}

         */

//        int[] arrayForSort = {8,3,5,2,1,4,7,6};
                int[] arrayForSort = randomArray(10);
//        System.out.println("Array before sort: ");
//        System.out.println(Arrays.toString(arrayForSort));

                ArraySort sort = new ArraySort();
                int iterations = sort.bubbleSort(arrayForSort);

                System.out.println("Array after sort (" + iterations + " iterations):");
//        System.out.println(Arrays.toString(arrayForSort));
        }
}
