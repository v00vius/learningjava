package ui;

import dto.Error;
import dto.Message;
import dto.Properties;
import service.Company;
import util.ConsoleIO;

public class EmployeeToDepartment implements MenuItem {
private Company company;

public EmployeeToDepartment(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Set a department fon an employee";
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

        Message command = new Properties("setDepartmentForEmployee");

        command.setProperty("id", id);
        command.setProperty("department", department);

        Message response = company.setDepartmentForEmployee(command);

        io.puts("Got response: " + response);

        if(response.getErrorCode() != 0)
                io.puts("" + new Error(response) + '\n');

        return false;
}
}
