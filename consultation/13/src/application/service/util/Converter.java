package application.service.util;

import application.core.dto.AddToDoRequest;
import application.core.dto.ToDoDto;
import application.core.entity.ToDoEntity;

public class Converter {

    public static ToDoEntity convertFromRequestToDo(AddToDoRequest request){
        ToDoEntity newEntity = new ToDoEntity();
        var entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public static ToDoDto converterFromEntityToDto(ToDoEntity entity){
        return new ToDoDto(entity.getName(), entity.getDescription());
    }
}
