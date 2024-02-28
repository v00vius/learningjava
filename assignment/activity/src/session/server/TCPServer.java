package session.server;

import dto.DTO;
import dto.StringDTO;

import java.io.*;
import java.net.ServerSocket;
import java.util.Optional;

public abstract class TCPServer implements Server {
private int port;
private ServerSocket socket;

private BufferedReader is;
private PrintWriter os;

private int acceptCount;

public TCPServer(int port)
{
        this.port = port;
}
@Override
public void start()
{
        try {
                socket = new ServerSocket(port, 5);

                System.err.printf("Listening: %s:%d\n",
                        socket.getLocalSocketAddress(),
                        socket.getLocalPort());

                boolean accept = true;

                while (accept) {
                        var client = socket.accept();

                        ++acceptCount;

                        System.err.printf("#%d Incoming: %s:%d\n",
                                acceptCount,
                                client.getInetAddress(),
                                client.getPort());

                        var isr = new InputStreamReader(client.getInputStream());                                
                        is = new BufferedReader(isr);
                        os = new PrintWriter(client.getOutputStream());

                        var dto = receive();

                        if(dto.isPresent()) {
                                DTO request = dto.get();
                                DTO response = new StringDTO();

                                System.err.printf("#%d Request: %s\n",
                                        acceptCount,
                                        dto.get());

                                accept = run(request, response);
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
                        isr.close();
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


public static void main(String[] args)
{
        Server server = new EchoServer(54321);

        server.start();
        System.err.println("Bye-bye!");
}
}
