package session;

import utils.data.DTO;

import java.io.IOException;
import java.util.Optional;

public interface Session {
        Optional<DTO> receive() throws IOException;
        boolean send(DTO message);
}
