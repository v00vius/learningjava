package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Row {
private int columns;
private List<String> data;
private Map<String, Integer> columnIndex;

public Row(int columns)
{
        this.columns = columns;
        data = new ArrayList<>();
        columnIndex = new HashMap<>();
}

public int getColumns()
{
        return columns;
}

public Row setName(int column, String name)
{
        columnIndex.put(name, column);
}

public void parse(String line)
{
        if(line == null)
                throw new IllegalArgumentException("Line is null");

        line = line.trim();

        if(line.isEmpty())
                throw new IllegalArgumentException("Line must not be empty");

        var start = line.indexOf('{');

        if(start == -1)
                throw new IllegalArgumentException("Line must begin with {");

        var end = line.indexOf('}');

        if(end == -1)
                throw new IllegalArgumentException("Line must end with }");

        line = line.substring(start + 1, end).trim();
        String[] words = line.split("[,:]");

        if(words.length != columns)
                throw new IllegalArgumentException("Number of columns must be " + columns);

        data = Arrays.asList(words);
}

public String getString(String name)
{
        return data.get(index(name));
}

public int getInt(String name)
{
        return Integer.parseInt(data.get(index(name)));
}
private int index(String name)
{
        var idx = columnIndex.getOrDefault(name, 0);

        if(idx == 0)
                throw new RuntimeException("Invalid column name: " + name);

        return idx;
}

public static void main(String[] args)
{
        var fileName = "";
        var row = new Row(6);

        BufferedReader in = new BufferedReader(new FileReader(fileName));
}
}
