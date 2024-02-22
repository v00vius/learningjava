package application.service;

import application.core.dto.AddToDoRequest;
import application.core.dto.AddToDoResponse;
import application.core.entity.ToDoEntity;
import application.repository.ToDoRepository;
import application.service.util.Converter;
import application.service.validation.ValidationService;


import java.util.ArrayList;

public class AddToDoService {
    private final ToDoRepository repository;
    private final ValidationService validationService;


    public AddToDoService(ToDoRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddToDoResponse add(AddToDoRequest request){

        var validationResult = validationService.validate(request);

        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddToDoResponse();
            response.setErrors(validationResult);
            return response;
        }

        var entity = Converter.convertFromRequestToDo(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

}
