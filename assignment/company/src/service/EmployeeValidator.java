package service;

import dto.Error;
import dto.Message;

public class EmployeeValidator implements Validator {
private final Message request;
private int errorCounter;
private Error error;

public EmployeeValidator(Message request, Message response)
{
        this.request = request;
        errorCounter = 0;
        error = new Error(response);
}

private void checkString(String tag, String name)
{
        name.trim();

        if(name.isEmpty())
                error.setError(++errorCounter, tag + ": must not be empty");

        if(name.length() < 3 || name.length() > 16)
                error.setError(++errorCounter, tag + ": '" + name + "': length should be 3 .. 16");
}
@Override
public int check()
{
        String firstName = request.getProperty("firstName");
        String lastName = request.getProperty("lastName");
        String jobPosition = request.getProperty("jobPosition");

        checkString("First name", firstName);
        checkString("Last name", lastName);
        checkString("Job Position", jobPosition);

        return errorCounter;
}
}
