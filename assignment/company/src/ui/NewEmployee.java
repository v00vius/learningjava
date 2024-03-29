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
                Printer.printEmployee(response, io);
                io.puts("The Employee has been created\n");
        } else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
