public class ArrayServiceTest {
    public static void main(String[] args) {
        ArrayService test = new ArrayService(30);

        test.randomFill(99);

        System.out.println("Initial array:");
        System.out.println(test);
        int iterations = test.bubbleSort();
        System.out.println("It took iterations for sorting: " + iterations);
        System.out.println(test);
    }
}
