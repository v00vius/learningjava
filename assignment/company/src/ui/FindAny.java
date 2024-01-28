package ui;

import dto.Errors;
import dto.Properties;
import dto.Registry;
import service.ReportManager;
import util.ConsoleIO;

public class FindAny implements MenuItem {
private ReportManager reportManager;

public FindAny(ReportManager reportManager)
{
        this.reportManager = reportManager;
}

@Override
public String getName()
{
        return "Free text search";
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
        Registry request = new Properties();

        request.set("/pattern", io.gets("What to search: "));
        io.puts("<<< " + request + '\n');

        Registry response = reportManager.findAny(request);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if (errors.isEmpty()) {
                if(0 == response.getInt("/employee/size"))
                        io.puts("Nothing has found\n");
                else
                        Printer.printEmployees(response, io);
        }
        else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
