package application.core.dto;

import application.service.validation.CoreError;

import java.util.List;

public class AddToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;

    public AddToDoResponse() {
    }
    public AddToDoResponse(Integer createdToDoId, List<CoreError> errors) {
        this.createdToDoId = createdToDoId;
        this.errors = errors;
    }

    public Integer getCreatedToDoId() {
        return createdToDoId;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    public void setCreatedToDoId(Integer createdToDoId) {
        this.createdToDoId = createdToDoId;
    }

    @Override
    public String toString() {
        return "AddToDoResponse{" +
                "createdToDoId=" + createdToDoId +
                ", errors=" + errors +
                '}';
    }
}
