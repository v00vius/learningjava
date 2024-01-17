package phone;

public class PhoneTest {
        SimCard sim1;
        SimCard sim2;
        Phone phone;

        public void doTest()
        {
                sim1 = new SimCard(123);
                sim2 = new SimCard(456);
                phone = new Phone(900, "Siemens ME45");

                PhoneService test = new PhoneService();

                println(phone.toString());
                println(sim1.toString());
                print("test 1: insertSimCard: ");

                if (test.insertSimCard(phone, sim1)) {
                        println("failed: Can't insert the SIM card");
                } else {
                        println("passed");
                }

                println("- - - -");


                sim1.setNumber(0);
                println(phone.toString());
                println(sim1.toString());
                print("test 2: insertSimCard: ");

                if (test.insertSimCard(phone, sim1)) {
                        println("failed: Can't insert the SIM card");
                } else {
                        println("passed");
                }

                println("- - - -");

                sim1.setNumber(123);
                println(phone.toString());
                println(sim1.toString());
                print("test 3: removeSimCard: ");

                SimCard sim3 = test.removeSimCard(phone);

                if (sim1 != sim3) {
                        println("failed: inserted and removed SIM cards aren't equal");
                } else {
                        println("passed");
                }

                println("- - - -");
        }

        void print(String s)
        {
                System.out.print(s);
        }

        void println(String s)
        {
                System.out.println(s);
        }

        public static void main(String[] args)
        {
                PhoneTest test = new PhoneTest();

                test.doTest();
        }
}
