package service;

import dto.Errors;
import dto.Registry;

public class PatternValidator implements Validator {
private final Registry request;
private Errors errors;

public PatternValidator(Registry request, Errors errors)
{
        this.request = request;
        this.errors = errors;
}

@Override
public boolean check()
{
        String pattern =  request.get("/pattern");

        if(pattern.isEmpty())
                errors.addError("Pattern shouldn't be empty");

        if(pattern.length() < 3)
                errors.addError("Pattern '" + pattern
                        + "' too short. The length must be 3 or more letters"
                );

        return errors.isEmpty();
}
}
