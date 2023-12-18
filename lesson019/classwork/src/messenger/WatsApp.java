package messenger;

import java.util.Random;

public class WatsApp extends BaseMessenger {
    @Override
    public String receive() {
        setMessage("WatsApp: received: " + new Random().nextInt(100));

        return getMessage();

    }

    @Override
    public boolean send(String message) {
        setMessage("WatsApp: send: " + message);
        return true;

    }
}
