package messenger;

import java.util.Random;

public class Telegram extends BaseMessenger {

    @Override
    public String receive() {
        setMessage("Telegram: received: " + new Random().nextInt(100));
        return getMessage();
    }

    @Override
    public boolean send(String message) {
        setMessage("telegram: send: " + message);
        return true;
    }
}
