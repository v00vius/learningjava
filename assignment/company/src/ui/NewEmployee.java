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
        Registry command = new Properties();

        command.setTag("/employee");
        command.set("firstName", io.gets("First Name: "));
        command.set("lastName", io.gets("Last Name: "));
        command.set("jobPosition", io.gets("Job Position: "));

        io.puts("<<< " + command + '\n');

        Registry response = company.newEmployee(command);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + "\n");

        if(errors.isEmpty()) {
                response.setTag("/employee");

                io.puts("The Employee has been created\n");
                io.puts("            ID: " + response.getInt("id") + '\n');
                io.puts("    First Name: " + response.get("firstName") + '\n');
                io.puts("     Last Name: " + response.get("lastName") + '\n');
                io.puts("  Job Position: " + response.get("jobPosition") + '\n');
        } else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
