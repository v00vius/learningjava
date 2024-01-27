package service;

import dto.Errors;
import dto.Registry;

public class EmployeeValidator implements Validator {
private final Registry request;
private int errorCounter;
private Errors error;

public EmployeeValidator(Registry request, Registry response)
{
        this.request = request;
        errorCounter = 0;
        error = new Errors(response);
}

private void checkString(String tag, String name)
{
        name.trim();

        if(name.isEmpty())
                error.addError(++errorCounter, tag + ": must not be empty");

        if(name.length() < 3 || name.length() > 16)
                error.addError(++errorCounter, tag + ": '" + name + "': length should be 3 .. 16");
}
@Override
public int check()
{
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        String jobPosition = request.get("jobPosition");

        checkString("First name", firstName);
        checkString("Last name", lastName);
        checkString("Job Position", jobPosition);

        return errorCounter;
}
}
