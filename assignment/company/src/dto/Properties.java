package dto;

import java.util.Hashtable;
import java.util.Map;

public class Properties implements Message {
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
public String getTag()
{
        return tag;
}
@Override
public int getErrorCode()
{
        String returnCode = getProperty(Keys.ERROR_CODE);

        return returnCode.isEmpty() ? 0 : Integer.parseInt(returnCode);
}

@Override
public void setErrorCode(int ec)
{
        String errorCode = Integer.toString(ec);
        setProperty(Keys.ERROR_CODE, errorCode);
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

// test
public static void main(String[] args)
{
        Properties message = new Properties("test props");

        message.setProperty("size", "2");
        message.setProperty("firstName 1", "John");
        message.setProperty("lastName 1", "Reed");
        message.setProperty("department 1", "Sales");

        message.setProperty("firstName 2", "John");
        message.setProperty("lastName 2", "Reed");
        message.setProperty("department 2", "R&D");

        message.setErrorCode(200);
        System.out.println(message);
        System.out.println(message.getTag() + ": rc=" + message.getErrorCode());
}
}
