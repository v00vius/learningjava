package ui;

import dto.Registry;
import repository.DepartmentManager;
import repository.EmployeeManager;
import service.ABCompany;
import service.Company;
import service.RandomCompany;
import service.ReportManager;
import util.ConsoleIO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Menu {
private final String name;
private List<MenuItem> items;
private ConsoleIO io;

public Menu(String name)
{
        this.name = name;
        this.items = new ArrayList<>();
        io = new ConsoleIO();
}

public MenuItem menuItem(MenuItem item)
{
        items.add(item);

        return item;
}
public void menu()
{
        boolean exit = false;

        while(!exit) {
                int itemNumber = 0;

                io.puts("\n>><< " + name +  " >><<\n");

                for (MenuItem item : items) {
                        ++itemNumber;

                        if(item.isEnabled())
                                io.puts("(" + itemNumber + ") " + item.getName() + '\n');
                        else
                                io.puts("( ) " + item.getName() + '\n');
                }

                int id = io.getInt("Select a menu item, please: ");

                io.puts("You have chosen the item #" + id + '\n');

                if (id < 1 || id > items.size()) {
                        io.puts("A menu item should be " + 1 + ".." + items.size() + '\n');
                        continue;
                }

                MenuItem item = items.get(id - 1);

                if(item.isEnabled())
                        exit = item.command();
        }
}

}
