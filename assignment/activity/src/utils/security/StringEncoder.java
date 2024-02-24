package utils.security;

import java.util.Random;

public class StringEncoder implements Encoder {
static private final long MAGIC1 = 31L;
static private final long MAGIC2 = 59L;
static private final int DELAY = 10_253;
private static Random random = new Random(37);
@Override
public String encode(String message)
{
        long encoded = MAGIC1;
        long mul = hash();

        for(long x : message.getBytes()) {
                encoded = mul * x + encoded;
        }

        return String.format("%X", encoded);
}

static private long hash() {
        long hash = MAGIC2;

        for (var i = 0; i < DELAY; ++i) {
                hash = MAGIC1 * random.nextLong() + hash;
        }

        return hash;
}

public static void main(String[] args)
{
        var msg = "password123";
        Encoder encoder = new StringEncoder();
        var hash = encoder.encode(encoder.encode(msg));

        System.out.printf("msg = '%s' passwd = '%s'", msg, hash);


}
}
