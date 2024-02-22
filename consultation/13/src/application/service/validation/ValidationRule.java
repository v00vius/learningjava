package application.service.validation;

import application.core.dto.AddToDoRequest;

import java.util.List;

public interface ValidationRule {
    void validate(AddToDoRequest request);
}
