package ui;

import dto.Errors;
import dto.Properties;
import dto.Registry;
import service.Company;
import util.ConsoleIO;

public class DismissEmployee implements MenuItem {
private Company company;

public DismissEmployee(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Dismiss a employee from the Company";
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
        io.puts("<<< " + command + '\n');

        Registry response = company.dismissEmployee(command);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + "\n");

        if (errors.isEmpty()) {
                Printer.printEmployee(response, io);
                io.puts("has been dismissed\n");
        } else
                io.puts("### " + errors + '\n');

        return false;
}

}
