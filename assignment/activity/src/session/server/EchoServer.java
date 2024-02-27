package session.server;

import utils.data.DTO;

public class EchoServer extends TCPServer {

public EchoServer(int port)
{
        super(port);
}

@Override
public boolean run(DTO request, DTO response)
{
        if(request.exists("bye"))
                return true;

        String msg = null;

        if(request.exists("msg")) {
                response.set("msg", request.get("msg"));
        } else {
                response.set("msg", "Usage: msg=text message");
        }

        return false;
}
}
