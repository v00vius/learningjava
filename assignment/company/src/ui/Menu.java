package ui;

import java.util.LinkedList;
import java.util.List;

public class Menu {
private List<MenuItem> items;

public Menu()
{
        this.items = new LinkedList<>();
}

public MenuItem menuItem(MenuItem item)
{
        items.add(item);

        return item;
}
}
