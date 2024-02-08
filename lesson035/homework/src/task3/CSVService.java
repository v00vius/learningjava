package task3;

import java.util.*;

public class CSVService implements CSV {
private List<List<Cell>> data;
private List<String> header;
private Map<String, Integer> index;
private final String delimiter;

public CSVService(String delimiter)
{
        this.delimiter = delimiter;
}
public void initData(List<String> lines)
{
        data = lines.stream()
                .skip(1)        // skip header
                .map(line ->
                        Arrays.stream(line.split(delimiter))
                                .map(Cell::new)
                                .toList()
                )
                .toList();
}
@Override
public void initHeader(String headerLine)
{
        header = Arrays.asList(headerLine.split(delimiter));
        index = new HashMap<>();

        for (int i = 0; i < header.size(); i++)
                index.put(header.get(i), i);
}
@Override
public Cell get(int row, int column)
{
        return data.get(row).get(column);
}
@Override
public Cell get(int row, String columName)
{
        int column = index.get(columName);

        return get(row, column);
}

public List<String> getHeader()
{
        return header;
}
@Override
public List<Cell> getColumn(int i)
{
        return data.stream()
                .map(line -> line.get(i))
                .toList();
}
@Override
public List<Cell> getColumn(String name)
{
        int column = index.get(name);

        return getColumn(column);
}
}
