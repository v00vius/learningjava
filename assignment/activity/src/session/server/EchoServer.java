package session.server;

import dto.DTO;

public class EchoServer extends TCPServer {

public EchoServer(int port)
{
        super(port);
}

@Override
public boolean run(DTO request, DTO response)
{
        if(request.exists("bye"))
                return false;

        String msg = null;

        if(request.exists("msg")) {
                response.set("msg", request.get("msg"));
        } else {
                response.set("msg", "Usage: msg=text message");
        }

        return true;
}
}
