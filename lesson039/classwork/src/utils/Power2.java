package utils;

public class Power2 {
static public boolean isPower2(int x)
{
        if(x == 0)
                return true;

        int count = 0;

        x = Math.abs(x);

        while(x > 0) {
                if((x & 0x01) == 1)
                        ++count;

                x >>>= 1;
        }

        return count == 1;
}
}
