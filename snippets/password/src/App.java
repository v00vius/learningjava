import netscape.javascript.JSObject;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;


public class App {
public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException
{
        var random = SecureRandom.getInstance("SHA1PRNG");

        char[] password = "123".toCharArray();
        byte[] salt = new byte[16];

        random.nextBytes(salt);

        PBEKeySpec keySpec = new PBEKeySpec(password, salt, 65535, 128);
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecretKeyFactory
        var factory  = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        var hash = factory.generateSecret(keySpec);
        var enc = Base64.getEncoder();
        var hashString = enc.encodeToString(hash.getEncoded());
        var saltString = enc.encodeToString(salt);

//        var key = factory.translateKey(hash);
        var factory2  = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        var spec = (PBEKeySpec)factory2.getKeySpec(hash, keySpec.getClass());

        System.out.println("# Password (KeySpec) = " + Arrays.toString(password));
        System.out.println("# Salt = '" + saltString + "', length " + saltString.length());
        System.out.println("algorithm = '" + hash.getAlgorithm() + "'");
        System.out.println("format = '" + hash.getFormat() + "'");
        System.out.println("is destroyed = '" + hash.isDestroyed() + "'");
        System.out.println("hash = '" + hashString + "', length " + hashString.length());
//        System.out.println("key =" + getEncoded(key.getEncoded()));
        System.out.println("Back to KeySpec (Password) = " + Arrays.toString(spec.getPassword()));

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
