package application.service;

import application.core.dto.AddToDoRequest;
import application.core.dto.FindByIdResponse;

public interface FindByIdService {
        FindByIdResponse find(AddToDoRequest request);
}
