import java.util.List;
import java.util.Random;

public class App {
public static void main(String[] args)
{
        Encoder encoder = new Encoder(".FFFF");
        Random rnd = new Random(System.currentTimeMillis());

        for (char ch = ' '; ch <= 'z'; ++ch) {
                encoder.createCode(ch, String.format(".%02X%02X", rnd.nextInt(100),
                        rnd.nextInt(100)));
        }

        System.out.println(encoder);

        String message = "abc";
        System.out.println("Input: " + message);

        char[] buf = Splitter.split(message);
        List<String> coded = EncodeEngine.encode(encoder, buf);
        String outputMessage = MessageProcessor.createCodedMessage(coded);

        System.out.println("Output:" + outputMessage);
}
}
