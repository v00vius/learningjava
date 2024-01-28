package ui;

import dto.Errors;
import dto.Properties;
import dto.Registry;
import service.Company;
import util.ConsoleIO;

public class DeleteDepartment implements MenuItem {
private Company company;

public DeleteDepartment(Company company)
{
        this.company = company;
}

@Override
public String getName()
{
        return "Delete a department (employees will not be deleted)";
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

        command.set("/department/name", io.gets("Enter the department to delete, please: "));
        io.puts("<<< " + command + '\n');

        Registry response = company.deleteDepartment(command);
        Errors errors = new Errors(response);

        io.puts(">>> " + response + '\n');

        if(!errors.isEmpty())
                io.puts("### " + errors);
        else {
                response.setTag("/department");

                io.puts("The following Department has been deleted\n");
                io.puts("    ID: " + response.getInt("id") + '\n');
                io.puts("  name: " + response.get("name") + '\n');
        }

        return false;
}
}
