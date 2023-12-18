package messenger;

public abstract class BaseMessenger  implements Messenger {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
