import java.util.Scanner;

public class App {
public static void main(String[] args)
{
        Scanner console = new Scanner(System.in);
        Maze2D maze = new Maze2D(5, 5);

        maze.init();

        while (maze.step() > 0) {
                System.out.println(maze);
                System.out.println("+++ <enter> to step");
                String s = console.nextLine();
        }

}
}
