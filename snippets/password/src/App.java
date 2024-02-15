import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;


public class App {
public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException
{
        char[] password = "The Password".toCharArray();
        byte[] salt = "The Salt".getBytes();

        PBEKeySpec keySpec = new PBEKeySpec(password, salt, 2, 256);
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecretKeyFactory
        var factory  = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        var hash = factory.generateSecret(keySpec);
        var key = factory.translateKey(hash);
        var spec = (PBEKeySpec)factory.getKeySpec(hash, keySpec.getClass());



        System.out.println("# Password (KeySpec) = " + Arrays.toString(password));
        System.out.println("# Salt = " + Arrays.toString(salt));
        System.out.println("algorithm = '" + hash.getAlgorithm() + "'");
        System.out.println("format = '" + hash.getFormat() + "'");
        System.out.println("is destroyed = '" + hash.isDestroyed() + "'");
        System.out.println("hash =" + getEncoded(hash.getEncoded()));
        System.out.println("key =" + getEncoded(key.getEncoded()));
        System.out.println("Back to KeySpec =" + Arrays.toString(spec.getPassword()));

        var random = SecureRandom.getInstance("SHA1PRNG");

        byte[] salt2 = new byte[16];

        random.nextBytes(salt2);
        System.out.println("salt2 =" + getEncoded(salt2));
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
