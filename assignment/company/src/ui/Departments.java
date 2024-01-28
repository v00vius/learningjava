package ui;

import dto.Errors;
import dto.Registry;
import service.ReportManager;
import util.ConsoleIO;

public class Departments implements MenuItem {
private ReportManager reportManager;

public Departments(ReportManager reportManager)
{
        this.reportManager = reportManager;
}

@Override
public String getName()
{
        return "List departments";
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
        Registry response = reportManager.departments();
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if (errors.isEmpty()) {
                response.setTag("/department");

                io.puts("Departments\n");

                for (int i = 0, size = response.getInt("size"); i < size; i++) {
                        String name = response.get("name", i);

                        io.puts("  " + name + '\n');
                }

        }
        else {
                io.puts("### " + errors + '\n');
        }

        return false;
}
}
