package dto.message;

import dto.DTO;

import java.util.ArrayList;
import java.util.List;

public class Message {
private int numErrors;
private DTO data;
private List<MessageItem> items;

public Message(DTO data)
{
        numErrors = 0;
        this.data = data;
        items = new ArrayList<>();
}

public DTO getDTO()
{
        return data;
}
public List<MessageItem> getItems()
{
        return items;
}
public MessageItem addItem(Subsystem subsystem, Severity severity, String message)
{
        MessageItem msg = new MessageItem(subsystem, severity, message);

        items.add(msg);

        if(severity == Severity.ERROR)
                ++numErrors;

        return msg;
}
public boolean hasErrors()
{
        return numErrors == 0;
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
