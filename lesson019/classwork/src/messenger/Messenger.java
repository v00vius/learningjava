package messenger;

public interface Messenger {
    String receive();
    boolean send(String message);
}
