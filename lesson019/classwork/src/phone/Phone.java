package phone;

import messenger.*;

public class Phone {
    BaseMessenger[] apps;
    BaseMessenger messenger;

    public Phone(BaseMessenger[] apps) {
        this.apps = apps;
    }

    public BaseMessenger getMessenger() {
        return messenger;
    }

    public void setMessenger(int msgr) {
        this.messenger = apps[msgr];
    }
}
