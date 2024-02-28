package storage;

import java.io.*;
import java.util.List;

public abstract class Storage<T> {
public List<T> load(BufferedReader is, Mapper<T> mapper)
{
        return is.lines()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .filter(s -> '#' != s.charAt(0))
                .map(mapper::mapToObject)
                .toList();
}

public int save(BufferedWriter os, List<T> data, Mapper<T> mapper)
{
        try {
                os.write("# Objects count: " + data.size() + '\n');

                for (var entity : data) {
                        String str = mapper.mapToString(entity);

                        os.write(str + '\n');
                }

                os.flush();
        } catch (IOException e) {
                System.err.println("Storage::save: " + e.getMessage());

                return -1;
        }

        return data.size();
}
}
