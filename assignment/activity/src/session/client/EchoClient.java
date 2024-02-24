package session.client;

import session.Session;
import utils.data.DTO;
import utils.data.StringDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

public class EchoClient implements Session {
private String server;
private int port;
private Socket socket;
private BufferedReader is;
private PrintWriter os;

public EchoClient(String server, int port)
{
        this.server = server;
        this.port = port;
}
private boolean connect()
{
        socket = null;
        is = null;
        os = null;

        try {
                socket = new Socket(server, port);
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
                System.err.println(e.getMessage());

                return false;
        }

        return true;
}
@Override
public Optional<DTO> receive() throws IOException
{
        String str = null;

        try {
                str = is.readLine();
                os.close();
                is.close();
                socket.close();
        } catch (IOException e) {
                System.err.println(e.getMessage());
        }

        if(str == null)
                return Optional.empty();

        DTO dto = new StringDTO(str);

        return Optional.of(dto);
}

@Override
public boolean send(DTO message)
{
        if (connect()) {
                os.write(message.toString() + '\n');
                os.flush();

                return true;
        }

        return false;
}

public static void main(String[] args) throws IOException
{
        Session client = new EchoClient("127.0.0.1", 54321);
        DTO dto = new StringDTO();


        for (int i = 0; i < 500; i++) {
                dto.fromString("msh=message - " + i);

                if(client.send(dto)) {
                        System.out.println("Sent: " + dto);

                        var rc = client.receive();
                        System.out.println("Got: " + rc.get());
                }
        }

        client.send(new StringDTO("bye"));
}
}
