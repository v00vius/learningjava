import utils.data.DTO;
import utils.data.StringDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import session.Endpoint;

public  class TCPClient implements Endpoint {
private String server;
private int port;
private Socket socket;

private InputStreamReader isr;
private BufferedReader is;
private PrintWriter os;

public TCPClient(String server, int port)
{
        this.server = server;
        this.port = port;
}
public List<DTO> getResponse(DTO request)
{
        List<DTO> dtos = new ArrayList<>();

        if (connect()) {
                send(request);
                System.out.println("Sent: " + request);

                try {
                        while(true) {
                                var response = receive();

                                if(response.isEmpty())
                                        break;

                                System.out.println("Got #" + dtos.size() + ": " + response.get());
                                dtos.add(response.get());
                        }
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }

                shutdown();
        }

        return dtos;
}
private boolean connect()
{
        socket = null;
        isr = null;
        is = null;
        os = null;

        try {
                socket = new Socket(server, port);
                isr = new InputStreamReader(socket.getInputStream());
                is = new BufferedReader(isr);
                os = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
                System.err.println(e.getMessage());

                return false;
        }

        return true;
}

private boolean shutdown()
{
        try {
                os.close();
                is.close();
                isr.close();
                socket.close();
        } catch (IOException e) {
                System.err.println(e.getMessage());

                return false;
        }

        return true;
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

public static void main(String[] args) throws IOException
{
        var client = new TCPClient("127.0.0.1", 54321);
        DTO dto = new StringDTO();


        for (int i = 0; i < 500; i++) {
                dto.fromString("msg=message - " + i);

                var response = client.getResponse(dto);
                System.out.println("Got: " + response.toString());
        }

        client.getResponse(new StringDTO("bye"));
}
}
