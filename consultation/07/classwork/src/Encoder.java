import java.util.Hashtable;
import java.util.Map;

public class Encoder {
private Map<Character, String> encoding;
private Map<String , Character> decoding;
private final String defaultCode;

public Encoder(String defaultCode)
{
        this.encoding = new Hashtable<>();
        this.decoding = new Hashtable<>();
        this.defaultCode = defaultCode;
}
public void createCode(char ch, String code)
{
        encoding.put(ch, code);
        decoding.put(code, ch);
}
public String encode(char ch)
{
        String v = encoding.get(ch);

        if(v == null)
                v = defaultCode;

        return v;
}

public char decode(String s)
{
        Character ch = decoding.get(s);

        if(ch == null)
                ch = '.';

        return ch;
}

@Override
public String toString()
{
        return "Encoder{" +
                ", defaultCode='" + defaultCode + '\'' +
                "encoding=" + encoding +
                '}';
}
}
