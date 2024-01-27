package ui;

import dto.Errors;
import dto.Registry;
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

        Registry props = new Properties();

        props.set("firstName", firstName);
        props.set("lastName", lastName);
        props.set("jobPosition", jobPosition);

        io.puts(props.toString() + '\n');

        Registry response = company.newEmployee(props);
        io.puts("Got: " + response + "\n");

        if(response.getErrorCode() == 0) {
                String id = response.get("id");

                io.puts("New Employee ID=" + id);
        } else {
                io.puts(new Errors(response).toString() + '\n');
        }

        return false;
}
}
