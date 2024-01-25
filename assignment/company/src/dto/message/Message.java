package dto.message;

public class Message {
private Object data;

public Message(Object data)
{
        this.data = data;
}

public Object getData()
{
        return data;
}

@Override
public String toString()
{
        return "Message{" +
               "data=" + data +
               '}';
}
}
