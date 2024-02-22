package application.service.validation;

import application.core.dto.AddToDoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationService {

    private final List<ValidationRule> validationRules;


    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(AddToDoRequest request){

        List<CoreError> errors = new ArrayList<>();

        if (request == null) {
            errors.add(new CoreError("ToDo request must not be null"));
            return errors;
        }
        return validationRules.stream()
                .map(rule -> validateEach(rule, request))
                .filter(Objects::nonNull)
                .toList();
    }

    private CoreError validateEach(ValidationRule rule, AddToDoRequest request){
        try {
            rule.validate(request);
        } catch (IllegalArgumentException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
