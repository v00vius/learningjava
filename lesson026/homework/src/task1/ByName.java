package task1;

public class ByName implements Comparator {
private final String name;

public ByName(String name)
{
        this.name = name;
}

@Override
public boolean match(Contact c1)
{
        return c1.getName().contains(name);
}

@Override
public String getName()
{
        return name;
}
}
