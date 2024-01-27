package ui;

import dto.Errors;
import dto.Registry;
import dto.Properties;
import service.Company;
import util.ConsoleIO;

public class NewDepartment implements MenuItem {
private Company company;

public NewDepartment(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Create a new department";
}

@Override
public boolean isEnabled()
{
        return true;
}

@Override
public boolean command()
{
        ConsoleIO io = new ConsoleIO();
        Registry command = new Properties();

        command.set("/department/name", io.gets("Enter the name of the new department, please: "));
        io.puts("<<< " + command + '\n');

        Registry response = company.newDepartment(command);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if(!errors.isEmpty())
                io.puts("### " + errors);
        else {
                response.setTag("/department");

                io.puts("The new Department has been created\n");
                io.puts("    ID: " + response.getInt("id") + '\n');
                io.puts("  name: " + response.get("name") + '\n');
        }

        return false;
}
}
