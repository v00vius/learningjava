import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class App {
public static void main(String[] args) throws IOException
{
        String matchesFile = "/home/vlan/IdeaProjects/cohort39.2/basic_programming/lesson_35/code/lessoncode/matches.txt";
        MatchLoader matchLoader = new FileLoader(matchesFile);

        List<Match> matches = matchLoader.load();

        System.out.println(matches);
}
}
