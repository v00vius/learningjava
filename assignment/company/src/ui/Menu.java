package ui;

import repo.DepartmentManager;
import repo.EmployeeManager;
import service.ABCompany;
import service.Company;
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

                io.puts("The item has been entered: " + id + '\n');

                if (id < 1 || id > items.size()) {
                        io.puts("A menu item should be " + 1 + ".." + items.size() + '\n');
                        continue;
                }

                MenuItem item = items.get(id - 1);

                if(item.isEnabled())
                        exit = item.command();
        }
}

public static void main(String[] args)
{
        DepartmentManager departments = new DepartmentManager();
        EmployeeManager employees = new EmployeeManager();
        Company company = new ABCompany("ABC test", departments, employees);

        Menu menu = new Menu("test");

        menu.menuItem(new ItemTest());

        menu.menuItem(new ItemExit());
        menu.menuItem(new NewEmployee(company));
        menu.menuItem(new DepartmentForEmployee(company));
        menu.menuItem(new EmployeesOfDepartment(company));
        menu.menuItem(new NewDepartment(company));

        menu.menu();
}
}
