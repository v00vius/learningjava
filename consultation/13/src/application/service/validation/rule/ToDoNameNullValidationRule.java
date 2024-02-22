package application.service.validation.rule;

import application.core.dto.AddToDoRequest;
import application.service.validation.ValidationRule;
public class ToDoNameNullValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName() == null) {
           throw new IllegalArgumentException("ToDo name must not be null");
        }
    }
}
