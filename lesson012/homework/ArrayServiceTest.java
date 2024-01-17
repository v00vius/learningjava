public class ArrayServiceTest {
        public static void main(String[] args)
        {
                ArrayService test = new ArrayService(30);

                test.randomFill(99);

                System.out.println("Initial array:");
                System.out.println(test);
                int iterations = test.bubbleSort();
                System.out.println("It took iterations for sorting: " + iterations);
                System.out.println(test);

                ArrayService test1 = new ArrayService(new int[]{3, 4, 0, 22, 1});
                System.out.println("Initial array:");
                System.out.println(test1);
                iterations = test1.bubbleSort();
                System.out.println("It took iterations for sorting: " + iterations);
                System.out.println(test1);

        }
}
