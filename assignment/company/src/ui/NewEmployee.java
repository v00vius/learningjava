package ui;

import dto.Properties;
import dto.message.Message;
import util.ConsoleIO;

public class NewEmployee implements MenuItem {
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

        Properties props = new Properties("New Employee");

        props.setProperty("firstName", firstName);
        props.setProperty("lastName", lastName);
        props.setProperty("jobPosition", jobPosition);

        io.puts(props.toString() + '\n');
        Message msg = new Message(props);


        return false;
}
}
