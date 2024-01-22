package task1;

public class ByPhone implements Comparator{
private final String name;

public ByPhone(String name)
{
        this.name = name;
}
@Override
public boolean match(Contact c1)
{
        return c1.getPhoneNumber().contains(name);
}

@Override
public String getName()
{
        return name;
}
}
