package ui;

public class ItemExit implements MenuItem {
@Override
public String getName()
{
        return "Exit";
}

@Override
public boolean isEnabled()
{
        return true;
}

@Override
public boolean command()
{
        System.out.println("Thanks! Bue!");

        return true;
}
}
