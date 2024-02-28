package session.server;

import session.Endpoint;
import dto.DTO;

public interface Server extends Endpoint {
        void start();
        boolean run(DTO request, DTO response);
}
