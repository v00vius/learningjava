package session.router;

import dto.DTO;
import session.server.TCPServer;

public class Router extends TCPServer {
public Router(int port)
{
        super(port);
}

@Override
public boolean run(DTO request, DTO response)
{
        return true;
}
}
