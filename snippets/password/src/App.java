import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;


public class App {
public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException
{
        char[] password = "1".toCharArray();
        byte[] salt = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F'};

        PBEKeySpec keySpec = new PBEKeySpec(password, salt, 31, 128);
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecretKeyFactory
        var factory  = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        var key = factory.generateSecret(keySpec);

        System.out.println("algorithm='" + key.getAlgorithm() + "'");
        System.out.println("format='" + key.getFormat() + "'");
        System.out.println("is destroyed='" + key.isDestroyed() + "'");
        System.out.println("key=" + getEncoded(key.getEncoded()));
}
static private String getEncoded(byte[] bytes)
{
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format(" %02X", 0x00FF & (int)bytes[i]));
        }

        return sb.toString();
}
}
