package ui;

import dto.Errors;
import dto.Registry;
import service.ReportManager;
import util.ConsoleIO;

public class Employees implements MenuItem {
private ReportManager reportManager;

public Employees(ReportManager reportManager)
{
        this.reportManager = reportManager;
}

@Override
public String getName()
{
        return "List employees";
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
        Registry response = reportManager.employees();
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if (errors.isEmpty()) {
                Printer.printEmployees(response, io);
        }
        else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
