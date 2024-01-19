package types;

public class PairInt {
static public int unpack1(long value)
{
        return (int) (value >>> 32);
}
static public int unpack0(long value)
{
        return (int) value;
}
}
