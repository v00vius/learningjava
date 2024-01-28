package ui;

import dto.Errors;
import dto.Registry;
import dto.Properties;
import service.Company;
import util.ConsoleIO;

public class EmployeesOfDepartment implements MenuItem {
private Company company;

public EmployeesOfDepartment(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "List employees of a department";
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

        command.set("/department/name", io.gets("Enter the name of the department, please: "));
        io.puts("<<< " + command + '\n');

        Registry response = company.getEmployeesOfDepartment(command);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if(errors.isEmpty())
                Printer.printEmployees(response, io);
        else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
