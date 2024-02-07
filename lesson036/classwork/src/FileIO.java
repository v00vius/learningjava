import java.io.*;
import java.util.stream.IntStream;

public class FileIO {
static public int cp(String fn1, String fn2) throws IOException
{
        File fileInput = new File(fn1);
        File fileOutpit = new File(fn2);
        InputStream is = new FileInputStream(fileInput);
        OutputStream os = new FileOutputStream(fileOutpit);
        byte[] buf = new byte[1024];
        int sz;
        int total = 0;


        while(-1 != (sz = is.read(buf))) {
                os.write(buf, 0, sz);
                total += sz;
        }

        is.close();
        os.close();

        return total;
}

public static void main(String[] args) throws IOException
{
        String src = "/home/vlan/tmp/transport.jpeg";
        String dst = "/home/vlan/tmp/transport-01.jpeg";

        System.out.println("# cp " + src + ' ' + dst + "...");

        int copied = cp(src, dst);

        System.out.println("# Done. " + copied + " bytes copied");
}
}
