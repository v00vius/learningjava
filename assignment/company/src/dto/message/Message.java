package dto.message;

import java.util.ArrayList;
import java.util.List;

public class Message {
//
// Subsystems
static public final int VERIFICATION = 1;
static public final int REPOSITORY = 2;
static public final int SERVICE = 3;
//
// Severity
static public final int ERROR = 1;
static public final int WARNING = 2;
static public final int INFORMATION = 3;

private Object data;
private List<MessageItem> items;

public Message(Object data)
{
        this.data = data;
        items = new ArrayList<>();
}

public Object getData()
{
        return data;
}
public List<MessageItem> getItems()
{
        return items;
}
public MessageItem addItem(int subsystem, int severity, String message)
{
        MessageItem msg = new MessageItem(subsystem, severity, message);

        items.add(msg);

        return msg;
}

@Override
public String toString()
{
        return "Message{" +
               "data=" + data +
               ", items=" + items +
               '}';
}
}
