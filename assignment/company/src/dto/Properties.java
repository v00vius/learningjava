package dto;

import dto.message.Message;
import dto.message.Severity;
import dto.message.Subsystem;

import java.util.Hashtable;
import java.util.Map;

public class Properties implements DTO {
private final String tag;
private Map<String, String> properties;

public Properties(String tag)
{
        this.tag = tag;
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

public int getPropertyInt(String name)
{
        return Integer.parseInt(getProperty(name));
}
public double getPropertyDouble(String name)
{
        return Double.parseDouble(getProperty(name));
}
@Override
public String toString()
{
        return "Properties \"" + tag + "\" " +  properties;
}

public static void main(String[] args)
{
        Properties dto = new Properties("test props");

        dto.setProperty("size", "2");
        dto.setProperty("firstName 1", "John");
        dto.setProperty("lastName 1", "Reed");
        dto.setProperty("department 1", "Sales");

        dto.setProperty("firstName 2", "John");
        dto.setProperty("lastName 2", "Reed");
        dto.setProperty("department 2", "R&D");

        Message msg = new Message(dto);

        msg.addItem(Subsystem.VERIFICATION, Severity.WARNING, "Name too long");
        msg.addItem(Subsystem.SERVICE, Severity.INFORMATION, "Employee accepted");

        System.out.println(msg);
        String value = dto.getProperty("size");
        double v = dto.getPropertyDouble("size");
        System.out.println(v);
}
}
