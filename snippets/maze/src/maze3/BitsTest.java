package maze3;

public class BitsTest {
public static void main(String[] args)
{
        Bits bits = new Bits(12, 10);

        bits.set(0, 0);
        bits.set(11, 0);
        bits.set(0, 9);
        bits.set(11, 9);

        System.out.println(bits);

        bits = new Bits(128);
        bits.set(0);
        bits.set(63);
        bits.set(64);
        bits.set(127);
        System.out.println(bits);
}
}
