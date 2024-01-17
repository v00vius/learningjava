import java.util.Scanner;

public class App {
public static void main(String[] args)
{
        Scanner console = new Scanner(System.in);
        Maze2D maze = new Maze2D(10, 10);

        maze.init();
        System.out.println("Initial graph\n" + maze);

        while (maze.step()) {
//                System.out.println(maze);
//                System.out.println("+++ <enter> to step");
//                String s = console.nextLine();
        }

//        maze.createBorders();
        System.out.println("Final graph\n" + maze);

}
}
