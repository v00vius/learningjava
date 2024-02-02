package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamTest {
private List<String> list;

public StreamTest(List<String> list)
{
        this.list = list;
}

public long testStream()
{
        long count = list.stream()
                .filter(s -> s.equals("10"))
                .count();

        return count;
}
public long testLoop()
{
        long count = 0;

        for (String s : list) {
                if(s.equals("10"))
                        ++count;
        }

        return count;
}


public static void main(String[] args)
{
        Random rnd = new Random(System.currentTimeMillis());
        List<String> testList = new ArrayList<>();

        for (int i = 0; i < 100_000_000; ++i) {
                testList.add(Integer.toString(rnd.nextInt(0, 40)));
        }


        StreamTest test = new StreamTest(testList);

        long delta = System.currentTimeMillis();
        long c1 = test.testStream();

        delta = System.currentTimeMillis() - delta;
        System.out.println("delta (stream) = " + delta);

        delta = System.currentTimeMillis();
        long c2 = test.testLoop();
        delta = System.currentTimeMillis() - delta;
        System.out.println("delta (loop) = " + delta);

}
}
