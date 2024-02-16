package utils;

public class Power2 {
static public boolean isPower2(int x)
{
        int count = 0;

        x = Math.abs(x);

        while(x > 0) {
                if((x & 0x01) == 1)
                        ++count;

                x >>>= 1;
        }

        return count == 1 || count == 0;
}

public static void main(String[] args)
{
        System.out.println(isPower2(32));
}
}
