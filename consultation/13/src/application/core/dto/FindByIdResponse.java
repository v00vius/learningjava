package application.core.dto;

import application.service.validation.CoreError;
import java.util.List;

public class FindByIdResponse {
private ToDoDto dto;
private List<CoreError> errors;

public FindByIdResponse()
{
}

public void setDto(ToDoDto dto)
{
        this.dto = dto;
}

public void setErrors(List<CoreError> errors)
{
        this.errors = errors;
}

@Override
public String toString()
{
        return "FindByIdResponse{" +
                "dto=" + dto +
                ", errors=" + errors +
                '}';
}
}
