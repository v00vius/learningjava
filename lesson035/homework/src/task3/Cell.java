package task3;

public class Cell {
private String data;

public Cell(String data)
{
        this.data = data;
}

public String get()
{
        return data;
}

public int getInt()
{
        return Integer.parseInt(data);
}
public double getDouble()
{
        return Double.parseDouble(data);
}

@Override
public String toString()
{
        return data;
}
}
