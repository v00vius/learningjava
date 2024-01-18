import java.util.List;

public class MessageProcessor {
static public String createCodedMessage(List<String> msg)
{
        String str = "";

        for(String s : msg)
                str += s;

        return str;
}
}
