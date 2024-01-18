import java.util.LinkedList;
import java.util.List;

public class EncodeEngine {
static public List<String> encode(Encoder encoder, char[] chars)
{
        List<String> message = new LinkedList<>();
        String coded = "";

        for (int i = 0, len = chars.length; i < len; ++i) {
                coded = encoder.encode(chars[i]);
                message.add(coded);
        }

        return message;
}
}
