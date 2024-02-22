package application.service;

import application.core.dto.FindAllToDoResponse;
import application.core.dto.ToDoDto;
import application.core.entity.ToDoEntity;
import application.repository.ToDoRepository;
import application.service.util.Converter;
import application.service.validation.CoreError;

import java.util.ArrayList;
import java.util.List;

public class FindToDoService {
    private final ToDoRepository repository;

    public FindToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public FindAllToDoResponse findAll(){
        List<ToDoEntity> entities = repository.findAll();
        List<ToDoDto> dtos = new ArrayList<>();
        List<CoreError> errors = new ArrayList<>();

        if (entities.isEmpty()) {
            errors.add(new CoreError("ToDo database is empty!"));
        } else {
            for (int i = 0; i < entities.size(); i++) {
                dtos.add(Converter.converterFromEntityToDto(entities.get(i)));
            }
        }
        return new FindAllToDoResponse(dtos, errors);
     }

}
