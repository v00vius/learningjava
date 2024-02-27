package session;

import utils.data.DTO;

import java.io.IOException;
import java.util.Optional;

public interface Endpoint {
        Optional<DTO> receive() throws IOException;
        boolean send(DTO message);
}
