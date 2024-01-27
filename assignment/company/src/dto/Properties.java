package dto;

import java.util.*;

public class Properties implements Registry {
static public final String DEFAULT_STRING = "";
static public final int DEFAULT_INT = 0;
private String tag;
private Map<String, String> properties;

public Properties()
{
        properties = new Hashtable<>();
        setTag();
}
@Override
public String getTag()
{
        return tag;
}
@Override
public void setTag()
{
        this.tag = "";
}
@Override
public void setTag(String name)
{
        this.tag = name.charAt(0) == '/' ? name : this.tag + '/' + name;
}
@Override
public boolean exists(String key)
{
        return null != properties.get(key(key));
}

@Override
public boolean exists(String key, int index)
{
        return exists(key + '/' + index);
}

private String key(String key)
{
        return key.charAt(0) == '/' ? key : tag + '/' + key;
}
@Override
public boolean set(String key, String value)
{
        return null == properties.put(key(key), value);
}

@Override
public boolean set(String key, int index, String value)
{
        return set(key + '/' + index, value);
}

@Override
public boolean set(String key, int value)
{
        return null == properties.put(key(key), Integer.toString(value));
}

@Override
public boolean set(String key, int index, int value)
{
        return set(key + '/' + index, value);
}

@Override
public boolean set(String key, double value)
{
        return null == properties.put(key(key), Double.toString(value));
}

@Override
public boolean set(String key, int index, double value)
{
        return set(key + '/' + index, value);
}

@Override
public String get(String name)
{
        String value = properties.get(key(name));

        return value == null ? DEFAULT_STRING : value;
}

@Override
public String get(String key, int index)
{
        return get(key + '/' + index);
}

@Override
public int getInt(String key)
{
        String value = properties.get(key(key));

        return value == null ? DEFAULT_INT : Integer.parseInt(value);
}

@Override
public int getInt(String key, int index)
{
        return getInt(key + '/' + index);
}

@Override
public double getDouble(String key)
{
        return Double.parseDouble(get(key));
}

@Override
public double getDouble(String key, int index)
{
        return getDouble(key + '/' + index);
}


@Override
public int getErrorCode()
{
        return exists("/errors/code") ? getInt("/errors/code") : 0;
}

@Override
public void setErrorCode(int ec)
{
        set("/errors/code", ec);
}

@Override
public String toString()
{
        StringBuilder builder = new StringBuilder("Properties\n");

        builder.append("  tag=").append(tag).append('\n');

        for (Map.Entry<String, String> e : properties.entrySet())
                builder.append("  ").append(e.getKey()).append("=").append(e.getValue()).append('\n');

        return builder.toString();
}

// test
public static void main(String[] args)
{
        Registry message = new Properties();

        System.out.println("error code = " + message.getErrorCode());

        message.setErrorCode(-1);
        System.out.println("error code = " + message.getErrorCode());

        System.out.println("tag = '" + message.getTag() + '\'');
        message.setTag("/employee");
        System.out.println("tag = '" + message.getTag() + '\'');
        message.setTag();
        System.out.println("tag = '" + message.getTag() + '\'');
        message.setTag("/department");
        System.out.println("tag = '" + message.getTag() + '\'');

        message.setTag();
        message.setTag("department");
        System.out.println("tag = '" + message.getTag() + '\'');

        message.setTag("R&D");
        System.out.println("tag = '" + message.getTag() + '\'');

        message.set("name", "John");
        System.out.println("name = '" + message.get("name") + '\'');
        message.set("lastName", "Reed");
        System.out.println("Last Name = '" + message.get("lastName") + '\'');
        System.out.println(message);

        message.set("size", 10);

        for (int i = 0; i < message.getInt("size"); ++i) {
                message.set("test", i, 10 + i);
        }

        System.out.println(message);

        for (int i = 0; i < message.getInt("size"); ++i) {
                int v = message.getInt("test", i);

                System.out.println(i + ") " + v);
        }
}
}
