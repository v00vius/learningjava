package session;

import dto.DTO;

import java.io.IOException;
import java.util.Optional;

public interface Endpoint {
        Optional<DTO> receive() throws IOException;
        boolean send(DTO message);
}
