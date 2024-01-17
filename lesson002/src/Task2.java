class Task3 {
        int number;
        int n1, n2, n3;

        Task3(int number)
        {
                this.number = number;
        }

        Task3 split()
        {
                int tmp = number;

//  Should be a loop here :-)
                n1 = tmp % 10;
                tmp /= 10;

                n2 = tmp % 10;
                tmp /= 10;

                n3 = tmp % 10;

                return this;
        }

        void print()
        {
                System.out.printf("The number: %d, last 3 digits: %d %d %d\n", number, n3, n2, n1);
        }
}

public class Task2 {
        char charVar;
        int intVar;
        byte byteVar;
        short shortVar;
        float floatVar;
        double doubleVar;
        long longVar;
        boolean bool;
        String sVar;
        Task2 self;

        Task2()
        {
                charVar = 'C';
                intVar = 65536;
                byteVar = 64;
                shortVar = -345;
                floatVar = 2e10F;
                doubleVar = -5e5;
                longVar = 9876554L;
                bool = true;
                sVar = "openjdk-21.0.1";
                self = this;
        }

        void print()
        {
                System.out.printf("charVar: '%c'\n"
                                  + "intVar: %d\n"
                                  + "byteVar: %d\n"
                                  + "shortVar: %d\n"
                                  + "floatVar: %f\n"
                                  + "doubleVar: %f\n"
                                  + "longVar: %d\n"
                                  + "bool: %S\n"
                                  + "sVar: \"%s\"\n"
                                  + "this: %s\n",
                        charVar,
                        intVar,
                        byteVar,
                        shortVar,
                        floatVar,
                        doubleVar,
                        longVar,
                        bool ? "YES" : "NO",
                        sVar,
                        self
                );
        }

        public static void main(String[] args)
        {
                Task2 theTask2 = new Task2();

                System.out.print("Task #2\n");

                theTask2.print();

                System.out.print("\n\nTask #3\n");

                Task3 theTask3a = new Task3(123);
                theTask3a.split().print();

                Task3 theTask3b = new Task3(4321);
                theTask3b.split().print();

                Task3 theTask3c = new Task3(9000);
                theTask3c.split().print();

        }
}
