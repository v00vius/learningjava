package service;

import dto.Errors;
import dto.Registry;

public class EmployeeValidator implements Validator {
private final Registry request;
private Errors errors;

public EmployeeValidator(Registry request, Errors errors)
{
        this.request = request;
        this.errors = errors;
}
@Override
public boolean check()
{
        request.setTag("/employee");
        checkString("First name", request.get("firstName"));
        checkString("Last name", request.get("lastName"));
        checkString("Job Position", request.get("jobPosition"));

        return errors.isEmpty();
}
private void checkString(String tag, String name)
{
        String prefix = tag + ": '" + name + "': ";

        name.trim();

        if(name.isEmpty())
                errors.addError( prefix + "must not be empty");

        if(name.length() < 3 || name.length() > 16)
                errors.addError( prefix + "the length should be 3 .. 16");

        String  ch = name.substring(0, 1);

        if(!ch.equals(ch.toUpperCase()))
                errors.addError( prefix + "the first letter must be a Capital one");
}
}
