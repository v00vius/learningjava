package messenger;

import java.util.Random;

public class Viber extends BaseMessenger {
    @Override
    public String receive() {
        setMessage("Viber: received: " + new Random().nextInt(100));

        return getMessage();

    }

    @Override
    public boolean send(String message) {
        setMessage("Viber: send: " + message);
        return true;

    }
}
