package ui;

import dto.Error;
import dto.Message;
import dto.Properties;

import service.Company;
import util.ConsoleIO;

public class NewEmployee implements MenuItem {
private Company company;

public NewEmployee(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Add a new employee to the Company";
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
        String firstName = io.gets("First Name: ");
        String lastName = io.gets("Last Name: ");
        String jobPosition = io.gets("Job Position: ");

        Message props = new Properties("newEmployee");

        props.setProperty("firstName", firstName);
        props.setProperty("lastName", lastName);
        props.setProperty("jobPosition", jobPosition);

        io.puts(props.toString() + '\n');

        Message response = company.newEmployee(props);
        io.puts("Got: " + response + "\n");

        if(response.getErrorCode() == 0) {
                String id = response.getProperty("id");

                io.puts("New Employee ID=" + id);
        } else {
                io.puts(new Error(response).toString() + '\n');
        }

        return false;
}
}
