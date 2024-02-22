package application.service;

import application.core.dto.AddToDoRequest;
import application.core.dto.FindByIdResponse;
import application.repository.ToDoRepository;
import application.service.util.Converter;
import application.service.validation.CoreError;
import application.service.validation.ValidationService;

public class FindById implements FindByIdService {
private final ToDoRepository repository;
private final ValidationService validationService;

public FindById(ToDoRepository repository, ValidationService validationService)
{
        this.repository = repository;
        this.validationService = validationService;
}


@Override
public FindByIdResponse find(AddToDoRequest request)
{
        var validation = validationService.validate(request);
        var response = new FindByIdResponse();

        if(!validation.isEmpty()) {
                System.out.println("The ID Validation failed, errors: " + validation);
                response.setErrors(validation);

                return response;
        }

        var toDo = repository.findById(request.getId());

        if (toDo.isEmpty()) {
                validation.add(new CoreError("ID " + request.getId() + " not found"));
                response.setErrors(validation);

                return response;
        }

        var dto = Converter.converterFromEntityToDto(toDo.get());
        response.setDto(dto);

        return response;
}
}
