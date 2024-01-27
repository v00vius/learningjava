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
        String department = io.gets("The existing department: ");

        Registry command = new Properties();

        command.set("department", department);

        Registry response = company.getEmployeesOfDepartment(command);

        io.puts("Got response: " + response + '\n');

        if(response.getErrorCode() != 0)
                io.puts("" + new Errors(response) + '\n');
        else {
                printDepartment(response, io);
        }

        return false;
}

private static void printDepartment(Registry response, ConsoleIO io)
{
        int sz = Integer.parseInt(response.get("size"));

        io.puts(String.format("%20s %20s %20s %20s\n",
                        "First Name",
                        "Last Name",
                        "Job Position",
                        "Department"
                )
        );

        io.puts(String.format("%20s %20s %20s %20s\n",
                        "----------",
                        "---------",
                        "------------",
                        "----------"
                )
        );

        for (int i = 0; i < sz; ++i) {
                String firstName = response.get("emp/" + i + "/FirstName");
                String lastName = response.get("emp/" + i + "/LastName");
                String jobPosition = response.get("emp/" + i + "/JobPosition");
                String dep = response.get("emp/" + i + "/Department");

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
