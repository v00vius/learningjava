package harwarestore;

import java.util.Arrays;

public class InstrumentKit {
        private String name;
        private Instrument[] instruments;

        public InstrumentKit(String name, Instrument tool1, Instrument tool2)
        {
                this.name = name;
                instruments = new Instrument[2];
                instruments[0] = tool1;
                instruments[1] = tool2;
        }

        public String getName()
        {
                return name;
        }

        @Override
        public String toString()
        {
                return "Kit " + name + ":\n"
                       + "  1. " + instruments[0] + "\n"
                       + "  2. " + instruments[1];
        }
}
