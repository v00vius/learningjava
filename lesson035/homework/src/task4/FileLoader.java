package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileLoader implements MatchLoader {
private String fileName;

public FileLoader(String fileName)
{
        this.fileName = fileName;
}

@Override
public List<Match> load() throws IOException
{
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        List<Match> matches = in.lines()
                // Ignore empty lines and comments
                .filter(s -> !s.trim().isEmpty() && !s.startsWith("#"))
                .map(s ->
                {
                        String[] fields = s.split(", ");

                        if(fields.length != 8)
                                return null;

                        Calendar date = parseDate(fields[0], fields[1], fields[2]);

                        Match match = new Match(date,
                                                fields[3],
                                                fields[4],
                                                fields[5],
                                                fields[6],
                                                fields[7]
                        );

                        return match;
                })
                .filter(Objects::nonNull)
                .toList();

        in.close();

        return matches;
}
static private Calendar parseDate(String year, String month, String day)
{
        Calendar date = Calendar.getInstance();

        date.set(Integer.parseInt(year),
                Integer.parseInt(month) - 1,
                Integer.parseInt(day),
                0, 0, 1
        );

        return date;
}

}
