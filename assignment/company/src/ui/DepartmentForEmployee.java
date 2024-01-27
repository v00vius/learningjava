package ui;

import dto.Errors;
import dto.Registry;
import dto.Properties;
import service.Company;
import util.ConsoleIO;

public class DepartmentForEmployee implements MenuItem {
private Company company;

public DepartmentForEmployee(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Set a department for an employee";
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
        String id = io.gets("Employee id: ");
        String department = io.gets("department: ");

        Registry command = new Properties();

        command.set("id", id);
        command.set("department", department);

        Registry response = company.setDepartmentForEmployee(command);

        io.puts("Got response: " + response + '\n');

        if(response.getErrorCode() != 0)
                io.puts("" + new Errors(response) + '\n');

        return false;
}
}
