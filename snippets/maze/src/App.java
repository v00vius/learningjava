import java.util.Scanner;

public class App {
public static void main(String[] args)
{
        Scanner console = new Scanner(System.in);
        Maze2D maze = new Maze2D(24, 80);

        maze.init();
        System.out.println("Initial graph\n" + maze);

        while (maze.step() > 0) {
//                System.out.println(maze);
//                System.out.println("+++ <enter> to step");
//                String s = console.nextLine();
        }

        System.out.println("Final graph\n" + maze);

}
}
