package ui;

public class ItemTest implements MenuItem {
@Override
public String getName()
{
        return "Test item";
}

@Override
public boolean isEnabled()
{
        return false;
}

@Override
public boolean command()
{
        System.out.println("Test");

        return false;
}
}
