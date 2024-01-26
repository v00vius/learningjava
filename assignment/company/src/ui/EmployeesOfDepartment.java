package ui;

import dto.Error;
import dto.Message;
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
        String department = io.gets("The existing department: ");

        Message command = new Properties("getEmployeesOfDepartment");

        command.setProperty("department", department);

        Message response = company.getEmployeesOfDepartment(command);

        io.puts("Got response: " + response + '\n');

        if(response.getErrorCode() != 0)
                io.puts("" + new Error(response) + '\n');
        else {
                printDepartment(response, io);
        }

        return false;
}

private static void printDepartment(Message response, ConsoleIO io)
{
        int sz = Integer.parseInt(response.getProperty("size"));

        for (int i = 0; i < sz; ++i) {
                String firstName = response.getProperty("emp/" + i + "/FirstName");
                String lastName = response.getProperty("emp/" + i + "/LastName");
                String jobPosition = response.getProperty("emp/" + i + "/JobPosition");
                String dep = response.getProperty("emp/" + i + "/Department");

                io.puts(String.format("%20s %20s %20s %20s\n",
                                firstName,
                                lastName,
                                jobPosition,
                                dep
                                )
                );
        }
}
}
