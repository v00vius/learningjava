package arrays2;

import arrays1.DynamicArray;

public class Task4 {

        static
        public Triple minMaxDifference(DynamicArray array)
        {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < array.getSize(); i++) {
                        if (array.get(i) < min) {
                                min = array.get(i);
                        } else if (array.get(i) > max) {
                                max = array.get(i);
                        }
                }

                return new Triple(max, min, max - min);
        }

        public static void main(String[] args)
        {
                DynamicArray array = new DynamicArray();
                array.fillRandom(30, 11);
                Triple result = minMaxDifference(array);

                System.out.println(array);
                System.out.println("Max/Min/Difference: "
                                   + result.getFirst() + "/"
                                   + result.getSecond() + "/" + result.getThird());
        }
}
