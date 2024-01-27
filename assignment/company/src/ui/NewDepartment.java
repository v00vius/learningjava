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
        String department = io.gets("The name of the new department: ");

        Registry command = new Properties();

        command.set("department", department);

        Registry response = company.newDepartment(command);

        io.puts("Got response: " + response + '\n');

        if(response.getErrorCode() != 0)
                io.puts("" + new Errors(response) + '\n');

        return false;
}
}
