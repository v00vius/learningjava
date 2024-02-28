package dto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDTO implements DTO {
private Map<String, String> mapper;
static private final char KV_DELIMITER = '=';
static private final String DELIMITER = "&";

public StringDTO()
{
        mapper = new HashMap<>();
}
public StringDTO(String str)
{
        mapper = new HashMap<>();

        fromString(str);
}
private StringDTO(Map<String, String> mapper)
{
        this.mapper = mapper;
}

@Override
public String get(String key)
{
        var value = mapper.get(key);

        if(value == null)
                throw new RuntimeException("Unknown key '" + key + "'");

        return value;
}
@Override
public long getInt(String key)
{
        String sValue = get(key);
        long value;

        try {
                value = Long.parseLong(get(key));
        } catch (NumberFormatException e) {
                throw new RuntimeException("The value '" + sValue +
                                        "' for the key '" + key +
                                        "' is not an Integer");
        }

        return value;
}
@Override
public boolean getBoolean(String key)
{
        var value = mapper.get(key);

        if(value == null)
                return false;

        if(value.isEmpty())
                return true;

        return value.equals("true");
}
@Override
public UUID getId(String key)
{
        String sValue = get(key);
        UUID id;

        try {
                id = UUID.fromString(sValue);
        } catch (IllegalArgumentException e) {
                throw new RuntimeException("The value '" + sValue +
                        "' for the key '" + key +
                        "' is not an ID");
        }

        return id;
}
@Override
public DTO set(String key, String value)
{
        mapper.put(key, value);

        return this;
}
@Override
public DTO set(String key, long value)
{
        String v = Long.toString(value);

        return set(key, v);
}
@Override
public DTO set(String key, UUID value)
{
        String v = value.toString();

        return set(key, v);
}

@Override
public String toString()
{
        if(mapper.isEmpty())
                return "";

        StringBuilder sb = new StringBuilder();

        for( var e :mapper.entrySet()) {
                sb.append(e.getKey())
                        .append(KV_DELIMITER)
                        .append(e.getValue())
                        .append(DELIMITER);
        }

        var len = sb.length();

        sb.delete(len - 1, len);

        return sb.toString();
}
@Override
public DTO fromString(String str)
{
        var addMap = Stream.of(str.trim().split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(pair -> {
                        String key;
                        String value;
                        var idx = pair.indexOf(KV_DELIMITER);

                        if(-1 == idx) {
                                key = pair;
                                value = "";
                        }
                        else {
                                key = pair.substring(0, idx);
                                value = pair.substring(idx + 1);
                        }

                        return new Map.Entry<String, String>() {
                                @Override
                                public String getKey()
                                {
                                        return key;
                                }

                                @Override
                                public String getValue()
                                {
                                        return value;
                                }

                                @Override
                                public String setValue(String value)
                                {
                                        return null;
                                }
                        };
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        mapper.putAll(addMap);

        return this;
}

@Override
public boolean exists(String key)
{
        return null != mapper.get(key);
}

public static void main(String[] args)
{
        DTO request = new StringDTO();

        //
        request.set("ID", UUID.randomUUID());
        request.set("name", "John");
        request.set("hash", 123456);

        System.out.println(request);

        //
        String message = request.toString();

        DTO response = new StringDTO(message);
        System.out.println(response);
        System.out.println("equals=" + request.toString().equals(response.toString()));

        //
        response = new StringDTO("msg=");
        System.out.println(response);
        //
        response = new StringDTO("msg");
        System.out.println(response);

        //
        request.set("hash", "eee");
        message = request.toString();
        response = new StringDTO(message);

        long hash = response.getInt("hash");
}
}
