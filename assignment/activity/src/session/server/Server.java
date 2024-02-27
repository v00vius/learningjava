package session.server;

import session.Endpoint;
import utils.data.DTO;

public interface Server extends Endpoint {
        void start();
        boolean run(DTO request, DTO response);
}
