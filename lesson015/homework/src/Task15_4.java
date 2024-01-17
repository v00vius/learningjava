import java.util.Random;

public class Task15_4 {
        private int[][] matrix;
        private int size;

        public Task15_4(int size)
        {
                matrix = new int[size][size];
                this.size = size;
        }

        public void transponse()
        {
                for (int i = 0; i < size; i++) {
                        for (int j = i + 1; j < size; j++) {
                                int tmp = matrix[i][j];

                                matrix[i][j] = matrix[j][i];
                                matrix[j][i] = tmp;
                        }
                }
        }

        public void fillRandom(int mod)
        {
                Random rnd = new Random();

                ++mod;

                for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                                matrix[i][j] = rnd.nextInt(mod);
                        }
                }
        }

        public void print()
        {
                for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                                if (j == 0) {
                                        print("  [" + matrix[i][j]);
                                } else {
                                        print("  " + matrix[i][j]);
                                }
                        }

                        println("]");
                }
        }

        public void println(String str)
        {
                System.out.println(str);
        }

        public void print(String str)
        {
                System.out.print(str);
        }

        public static void main(String[] args)
        {
                Task15_4 task = new Task15_4(8);

                task.fillRandom(99);
                task.println("Before:");
                task.print();

                task.println("After:");
                task.transponse();
                task.print();
        }
}
