package task3;

import javax.sound.midi.Soundbank;
import java.net.SocketOption;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Remainder {
        private String name;
        private int secondsForWork;

        public Remainder(String name, int secondsForWork)
        {
                this.name = name;
                this.secondsForWork = secondsForWork;
        }

        public int getSecondsForWork()
        {
                return secondsForWork;
        }

        public int getHoursForWork()
        {
                return secondsForWork / 3600;
        }

        @Override
        public String toString()
        {
                return name + ", remainder:\n"
                       + "\tSeconds for work: " + getSecondsForWork() + "\n"
                       + "\tHours for work: " + getHoursForWork();
        }


        public static void main(String[] args)
        {

                Random rnd = new Random();

                Remainder rem1 = new Remainder("room 311", rnd.nextInt(0, 28800));
                Remainder rem2 = new Remainder("room 312", rnd.nextInt(0, 28800));
                Remainder rem3 = new Remainder("room 421", rnd.nextInt(0, 28800));
                Remainder rem4 = new Remainder("room 422", rnd.nextInt(0, 28800));

                System.out.println(rem1);
                System.out.println(rem2);
                System.out.println(rem3);
                System.out.println(rem4);

        }
}
