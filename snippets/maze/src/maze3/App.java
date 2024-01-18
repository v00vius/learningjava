package maze3;

public class App {
public static void main(String[] args)
{
        Maze2D maze = new Maze2D(2, 2);

        Maze2D.Edge e = maze.init();

        while (e != null) {
                e = maze.step(e);
        }

        System.out.println(maze);
}
}
