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
        Registry command = new Properties();

        command.set("/employee/id", io.gets("Employee id: "));
        command.set("/department/name", io.gets("Department: "));

        io.puts("<<< " + command + '\n');

        Registry response = company.setDepartmentForEmployee(command);

        Errors errors = new Errors(response);

        io.puts(">>> " + response + "\n");

        if (errors.isEmpty()) {
                io.puts("The Department for the Employee has been changed\n");
                io.puts("  Employee ID: " + response.get("/employee/id") + '\n');
                io.puts("   Department: " + response.get("/department/name") + '\n');
        } else
                io.puts("### " + errors + '\n');

        return false;
}
}
