package application.core.dto;

import application.service.validation.CoreError;

import java.util.List;

public class FindAllToDoResponse {
    private List<ToDoDto> dtos;
    private List<CoreError> errors;

    public FindAllToDoResponse(List<ToDoDto> dtos, List<CoreError> errors) {
        this.dtos = dtos;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "FindAllToDoResponse{" +
                "dtos=" + dtos +
                ", errors=" + errors +
                '}';
    }
}
