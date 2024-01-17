//
// 2023-11-09
//      In this example we declare a simple class NetworkInterface,
//      create instances of the given class,
//      modify them,
//      and finally print a result.
//

package test1;

//import java.util.Locale;
public class NetworkInterface {
        protected String name;
        protected int speed = 10;   // 1/10/100 GbE
        protected boolean isUp = false;
        protected String ipAddress;
        protected int ipNetmask;

        protected long bytesSend = 0;
        protected long bytesRecv = 0;

        // The interface creation count
        public static int usageCount = 0;

        public NetworkInterface(String name, String ipAddress, int ipNetmask)
        {
                this.name = name;
                this.ipAddress = ipAddress;
                this.ipNetmask = ipNetmask;

                ++usageCount;
        }

        public void print()
        {
                System.out.printf(/*Locale.US, */ "%s: flags=<%S>\n"
                                                  + "\tinet %s netmask 0x%X\n"
                                                  + "\tmedia: %d GbE\n"
                                                  + "\tRX bytes %16d\n\tTX bytes %16d\n\n",
                        name,
                        isUp() ? "up" : "down",
                        ipAddress,
                        ipNetmask,
                        speed,
                        bytesRecv,
                        bytesSend
                );
        }

        // adds statistics for a network interface
        public void addStats(long bytesSend, long bytesRecv)
        {
                this.bytesSend += bytesSend;
                this.bytesRecv += bytesRecv;
        }

        // tests whether an interface is up
        public boolean isUp()
        {
                return isUp;
        }

        // forces an interface to be up and returns a previous state
        public boolean up()
        {
                boolean prevState = isUp;

                isUp = true;

                return prevState;
        }

        // forces an interface to be down and returns a previous state
        public boolean down()
        {
                boolean prevState = isUp;

                isUp = false;

                return prevState;
        }
}

/*
class Main {
    public static void main(String[] args) {

        {
            NetworkInterface if_lan = new NetworkInterface("em0.2", "192.168.20.1", 0xFFFFFF00);
            if_lan.addStats(1126329781L, 3788146194L);

            NetworkInterface if_wifi = new NetworkInterface("em0.3", "192.168.30.1", 0xFFFFFF00);
            if_wifi.addStats(5118740L, 65164L);

            NetworkInterface if_gw = new NetworkInterface("em0.5", "192.168.50.1", 0xFFFFFF00);
            if_gw.addStats(9533864942L, 15595828813L);

            if(!if_gw.isUp())
                if_gw.up();

            if(!if_lan.isUp())
                if_lan.up();

            System.out.print("Available network interfaces are:\n");
            if_lan.print();
            if_wifi.print();
            if_gw.print();
        }

        System.out.printf("Interface(s) usage count: %d\n", NetworkInterface.usageCount);
    }
}
*/