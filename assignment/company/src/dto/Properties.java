package dto;

import dto.message.Message;
import dto.message.Severity;
import dto.message.Subsystem;

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
public boolean isEmpty()
{
        return properties.isEmpty();
}
@Override
public String toString()
{
        return "Properties" + properties;
}

public static void main(String[] args)
{
        Properties dto = new Properties();

        dto.setProperty("type", "Employee");
        dto.setProperty("firstName 1", "John");
        dto.setProperty("lastName 1", "Reed");
        dto.setProperty("department 1", "R&");
        dto.setProperty("department 1", "Sales");

        Message msg = new Message(dto);

        msg.addItem(Subsystem.VERIFICATION, Severity.WARNING, "Name too long");
        msg.addItem(Subsystem.SERVICE, Severity.INFORMATION, "Employee accepted");

        System.out.println(msg);
}
}
