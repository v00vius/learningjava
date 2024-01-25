package dto;

import dto.message.Message;

import java.util.Hashtable;
import java.util.Map;

public class Properties implements DTO {
private Map<String, String> properties;

public Properties()
{
        properties = new Hashtable<>();
}
@Override
public boolean setProperty(String name, String value)
{
        return null == properties.put(name, value);
}
@Override
public String getProperty(String name)
{
        String value = properties.get(name);

        return value == null ? "" : value;
}

@Override
public String toString()
{
        return "Properties{" +
               "properties=" + properties +
               '}';
}

public static void main(String[] args)
{
        Properties dto = new Properties();

        dto.setProperty("firstName", "John");
        dto.setProperty("lastName", "Reed");
        dto.setProperty("department", "R&");
        dto.setProperty("department", "R&D");

        Message msg = new Message(dto);

        msg.addItem(Message.VERIFICATION, Message.WARNING, "Name too long");
        msg.addItem(Message.SERVICE, Message.INFORMATION, "Employee accepted");

        System.out.println(msg);
}
}
