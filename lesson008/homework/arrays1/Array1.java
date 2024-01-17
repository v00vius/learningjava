package arrays1;

import utils.UserInterface;
import utils.Utils;

import java.util.Arrays;
import java.util.Random;

public class Array1 {
        private int[] data;

        public Array1(int size)
        {
                if (size < 2) {
                        Utils.fatalExit("Invalid array size: " + size);
                }

                data = new int[size];
                Random rnd = new Random();

                for (int i = 0; i < data.length; )
                        data[i++] = rnd.nextInt(101);
        }

        public Array1()
        {
                data = new int[]{2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5};
        }

        public int get(int idx)
        {
                return data[idx];
        }

        public int set(int idx, int value)
        {
                int prev = data[idx];
                data[idx] = value;

                return prev;
        }

        public int getIndexOfMax()
        {
                int idx = -1;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < data.length; i++) {
                        if (data[i] > max) {
                                idx = i;
                                max = data[i];
                        }
                }

                return idx;
        }

        public int getSum()
        {
                int sum = 0;

                for (int i = 0; i < data.length; ++i)
                        sum += data[i];

                return sum;
        }

        public Array1 getArrayOfMax()
        {
                int iMax = getIndexOfMax();
                int max = get(iMax);
                int count = 0;

                // Pass 1
                for (int i = iMax; i < data.length; i++) {
                        if (max == data[i]) {
                                ++count;
                        }
                }

                if (count < 2) {
                        return null;
                }

                Array1 array = new Array1(count);

                // Pass 2
                for (int i = iMax, j = 0; i < data.length; i++) {
                        if (max == data[i]) {
                                array.set(j++, i);
                        }
                }

                return array;
        }

        @Override
        public String toString()
        {
                return Arrays.toString(data);
        }

        public static void main(String[] args)
        {
                Array1 array = new Array1(new UserInterface().getInt("Enter the array size: "));

                int iMax = array.getIndexOfMax();
                int max = array.get(iMax);
                int sum = array.getSum();

                System.out.println(array);
                System.out.println("#-----------");
                System.out.println("  Index: " + iMax + ", value: " + max + ", sum: " + sum);

                Array1 array1 = new Array1();

                iMax = array1.getIndexOfMax();
                max = array1.get(iMax);
                sum = array1.getSum();

                System.out.println(array1);
                System.out.println("#-----------");
                System.out.println("  Index: " + iMax + ", value: " + max + ", sum: " + sum);

                Array1 arrayMax = array1.getArrayOfMax();

                System.out.println("Indexes of max elements (" + max + ") are:");
                System.out.println("  " + arrayMax);
        }
}
