import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class App {
public static void main(String[] args) throws IOException
{
        String matchesFile = "/home/vlan/IdeaProjects/cohort39.2/basic_programming/lesson_35/code/lessoncode/matches.txt";
        MatchLoader matchLoader = new FileLoader(matchesFile);

        List<Match> matches = matchLoader.load();

        System.out.println("# The loaded records ---------------------------");
        System.out.println(matches);

        // (a), (b)
        List<Match> firstHalsMonth = matches.stream()
                .filter(m -> m.getDate().get(Calendar.DAY_OF_MONTH) < 16)
                .toList();

        System.out.println("# Matches in the first half of a month (" + firstHalsMonth.size() + " matches)");
        System.out.println(firstHalsMonth);

        // (c)
        List<Match> top10watchers = matches.stream()
                .sorted((m1, m2) -> m2.getWatchers() - m1.getWatchers())
                .limit(10)
                .toList();

        System.out.println("# Top 10 matches attendance");
        System.out.println(top10watchers);

        // (d) stadium = WWK Arena, top 3 difference
        List<Match> top3difference = matches.stream()
                .filter(m -> 0 == m.getStadium().compareToIgnoreCase("WWK Arena"))
                .sorted((m1, m2) ->
                {
                        int diff1 = Math.abs(m1.getResult1() - m1.getResult2());
                        int diff2 = Math.abs(m2.getResult1() - m2.getResult2());

                        return diff1 - diff2;
                })
                .limit(3)
                .toList();

        System.out.println("# Top 3 matches with the max score difference at the WWK Arena");
        System.out.println(top3difference);

        // (e)
        int count = (int)matches.stream()
                .filter(m -> 0 == m.getStadium().compareToIgnoreCase("WWK Arena"))
                .count();

        System.out.println("# WWK Arena count: " + count);

        // (f)
        Map<String, Long> guestMatches = matches.stream()
                .collect(Collectors.groupingBy(Match::getTeam2, TreeMap::new, Collectors.counting()));

        System.out.println("# Guest matches by a team");
        System.out.println(guestMatches);
}
}
