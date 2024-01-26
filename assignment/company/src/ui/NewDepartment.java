package ui;

import dto.Error;
import dto.Message;
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

        Message command = new Properties("newDepartment");

        command.setProperty("department", department);

        Message response = company.newDepartment(command);

        io.puts("Got response: " + response + '\n');

        if(response.getErrorCode() != 0)
                io.puts("" + new Error(response) + '\n');

        return false;
}
}
