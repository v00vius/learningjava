package test1;

public class InAddr4 {
    protected short[] bytes;
    protected boolean isValid = true;

    private void empty() {
        bytes = new short[4];

        bytes[0] = bytes[1] = bytes[2] = bytes[3] = 0;
        isValid = true;
    }
    void print() {
        if(isValid)
            System.out.printf("%d.%d.%d.%d\n", bytes[0], bytes[1], bytes[2], bytes[3]);
        else
            System.out.print("[invalid inet4 addr]\n");
    }
    public InAddr4() {
        empty();
    }
    public InAddr4(int b0, int b1, int b2, int b3) {
        empty();

        if(b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0
            || b0 > 255 || b1 > 255 || b2 > 255 || b3 > 255) {

            isValid = false;
            return;
        }

        bytes[0] = (short) b0;
        bytes[1] = (short) b1;
        bytes[2] = (short) b2;
        bytes[3] = (short) b3;
    }
    public InAddr4(String sAddr) {
        empty();
        String[] s = sAddr.split("\\.", 5);

//        System.out.printf("s='%s', length=%d\n", sAddr, s.length);

        if(s.length < 4) {
            isValid = false;
            return;
        }


        for(int i = 0; i < 4; ++i) {
//            System.out.printf("%d '%s'\n", i, s[i]);
//            short val = Short.parseShort(s[i]);
            short val = Short.decode(s[i]);

            if (val >= 0 && val <= 255)
                bytes[i] = val;
            else {
                isValid = false;
                return;
            }
        }

//        System.out.print("\n");
    }
}

class Main  {
    public static void main(String[] args) {
        InAddr4 a1 = new InAddr4("10.12.13.14");
        a1.print();

        InAddr4 a2 = new InAddr4();
        a2.print();

        InAddr4 a3 = new InAddr4(192, 168, 20, 255);
        a3.print();
    }
}