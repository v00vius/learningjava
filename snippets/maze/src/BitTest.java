import types.BitsManip;

public class BitTest {
public static void main(String[] args)
{
        byte[] bits = new byte[1];

        System.out.println("+++ test setBit +++");

        for (int i = 0; i < 8; ++i) {
                BitsManip.setBit(bits, i);
                System.out.println(BitsManip.prints(bits));
        }

        System.out.println("+++ test slrBit +++");
//        bits[0] = (byte) 0xFF;

        for (int i = 0; i < 8; ++i) {
                BitsManip.clrBit(bits, i);
                System.out.println(BitsManip.prints(bits));
        }

        bits[0] = (byte) 0xFF;
        System.out.println(BitsManip.prints(bits));
        BitsManip.set(bits, (byte)5, (byte) 0x0F);
        System.out.println(BitsManip.prints(bits));
}
}
