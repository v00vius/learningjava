package storage;

import utils.data.Mapper;

import java.io.*;
import java.util.List;

public abstract class Storage<T> {
public List<T> load(BufferedReader is, Mapper<T> mapper)
{
        return is.lines()
                .map(mapper::mapToObject)
                .toList();
}

public int save(BufferedWriter os, List<T> data, Mapper<T> mapper)
{
        try {
                for (var entity : data) {
                        String str = mapper.mapToString(entity) + '\n';

                        os.write(str);
                }

                os.flush();
        } catch (IOException e) {
                return -1;
        }

        return data.size();
}
}
