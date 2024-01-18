package maze2;

import java.util.Scanner;

public class App {
public static void main(String[] args)
{
        Scanner console = new Scanner(System.in);
        Maze2D maze = new Maze2D(1_000, 1_000);
        int totalIterations = 11;
        long avg = 0;

        for (int i = 0; i < totalIterations; ++i)
        {
                maze.init();
//        System.out.println("Initial graph\n" + maze);

                long start = System.currentTimeMillis();

                while (maze.step()) {
//                System.out.println(maze);
//                System.out.println("+++ <enter> to step");
//                String s = console.nextLine();
                }

                long end = System.currentTimeMillis() - start;

                avg += end;

//                maze.createBorders();
//                System.out.println("Final graph\n" + maze);
                System.out.println(String.format("%03d) Delta time %s ms, %d edges", i, end, maze.getGraph().size()));
        }

        System.out.println(String.format("AVG Delta time %d ms (on %d iterations)", avg / totalIterations, totalIterations));
}
}
