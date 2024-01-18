package types;

public class BitsManip {
static public void setBit(byte[] b, int index)
{
        b[0] |= (byte)(1 << index);
}
static public void clrBit(byte[] b, int index)
{
        b[0] &= (byte)~(1 << index);
}
static public void set(byte[] b, byte bits, byte mask)
{
        b[0] = (byte)((b[0] & ~mask) | bits);
}
static public void clr(byte[] b, byte mask)
{
        set(b, (byte)0, mask);
}
static public String prints(byte[] b)
{
        String s = String.format("0x%02x:\n", b[0]);

        for (int i = 0; i < 8; ++i) {
                char ch = ((1 << i) & b[0]) > 0 ? '1' : '0';

                s += String.format("%d: %c\n", i, ch);
        }

        return s;
}
}
