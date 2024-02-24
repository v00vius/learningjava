package session.server;

import utils.data.DTO;
import utils.data.StringDTO;

import java.io.*;
import java.net.ServerSocket;
import java.util.Optional;

public class EchoServer implements Server {
private ServerSocket socket;
private BufferedReader is;
private PrintWriter os;
private int acceptCount;
public EchoServer()
{

}
void listen(int port)
{
        try {
                socket = new ServerSocket(port, 5);

                System.err.printf("Listening: %s:%d\n",
                        socket.getLocalSocketAddress(),
                        socket.getLocalPort());

                boolean exit = false;

                while (!exit) {
                        var client = socket.accept();

                        ++acceptCount;

                        System.err.printf("#%d Incoming: %s:%d\n",
                                acceptCount,
                                client.getInetAddress(),
                                client.getPort());

                        is = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        os = new PrintWriter(client.getOutputStream());

                        var dto = receive();

                        if(dto.isPresent()) {
                                DTO request = dto.get();
                                DTO response = new StringDTO();

                                System.err.printf("#%d Request: %s\n",
                                        acceptCount,
                                        dto.get());

                                exit = run(request, response);
                                send(response);

                                System.err.printf("#%d Response: %s\n",
                                        acceptCount,
                                        response);
                        } else {
                                System.err.printf("#%d Request: empty\n",
                                        acceptCount);
                        }

                        os.close();
                        is.close();
                        client.close();
                }
        } catch (IOException e) {
                System.err.println(e.getMessage());
        }
}
@Override
public Optional<DTO> receive() throws IOException
{
        String str = is.readLine();

        if(str == null)
                return Optional.empty();

        DTO dto = new StringDTO(str);

        return Optional.of(dto);
}

@Override
public boolean send(DTO message)
{
        os.write(message.toString() + '\n');
        os.flush();

        return true;
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

public static void main(String[] args)
{
        var server = new EchoServer();

        server.listen(54321);
        System.err.println("Bye-bye!");
}
}
