package session.server;

import session.Session;
import utils.data.DTO;

public interface Server extends Session {
        boolean run(DTO request, DTO response);
}
