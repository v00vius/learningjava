package application.service.validation.rule;

import application.core.dto.AddToDoRequest;
import application.service.validation.ValidationRule;

public class ToDoCheckId  implements ValidationRule {
@Override
public void validate(AddToDoRequest request)
{
        if (request.getId() == null) {
                throw new IllegalArgumentException("ToDo ID must not be null");
        }
}
}
