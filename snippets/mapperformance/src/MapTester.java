import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapTester {
private Map<String, String> aMap;
private int testSize;
private int testIterations;

public MapTester(int testSize, int testIterations)
{
        this.testSize = testSize;
        this.testIterations = testIterations;
}

public Map<String, String> getMap()
{
        return aMap;
}

public void setMap(Map<String, String> aMap)
{
        this.aMap = aMap;
}

public double test()
{
        double avg = 0.0;

        for (int i = 0; i < testIterations; ++i) {
                double deltaTime = currentTimeSecs();

                aMap.clear();

                long written = writeMap();
                long read = readMap();

                deltaTime = currentTimeSecs() - deltaTime;

                System.out.printf("%03d) %5.3f seconds, %s\n",
                        i, deltaTime, (read - written == 0) ? "OK" : "FAIL");

                avg += deltaTime;
        }

        avg /= (double) testIterations;

        return avg;
}

static private double currentTimeSecs()
{
       return (double) System.currentTimeMillis() / 1000.0;
}
private long writeMap()
{
        long sum = 0;

        for (int i = 0; i < testSize; ++i) {
                String aKey = makeKey(i);
                String aValue = makeValue(i);

                aMap.put(aKey, aValue);
                sum += aValue.length();
        }

        return sum;
}
private long readMap()
{
        long sum = 0;

        for (int i = 0; i < testSize; ++i) {
                String aKey = makeKey(i);
                String aValue = aMap.get(aKey);

                sum += aValue.length();
        }

        return sum;
}

private String makeKey(int i)
{
        return "/key/" + i % 256 + "/" + i;
}
private String makeValue(int i)
{
        return "value=" + i;
}

public static void main(String[] args)
{
        MapTester mapTester = new MapTester(100_000, 10);
        mapTester.setMap(new HashMap<>());

        double avg = mapTester.test();
        System.out.printf("HashMap: %5.3f seconds average\n", avg);

        mapTester.setMap(new Hashtable<>());
        avg = mapTester.test();
        System.out.printf("Hashtable: %5.3f seconds average\n", avg);

        mapTester.setMap(new TreeMap<>());
        avg = mapTester.test();
        System.out.printf("TreeMap: %5.3f seconds average\n", avg);
}
}
