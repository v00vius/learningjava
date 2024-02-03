public class Telemetry {
private final int loopCount;

public Telemetry(int loopCount)
{
        this.loopCount = loopCount;
}

static public double currentTimeSeconds()
{
        return (double)System.currentTimeMillis() / 1000.;
}

public void test(String testName,  TelemetryAction task)
{
        double delta = currentTimeSeconds();

        for (int i = 0; i < loopCount; ++i)
                task.task();

        delta = currentTimeSeconds() - delta;
        double ops = (double) loopCount / delta;


        System.out.println("Test: " + testName + ", " + loopCount
                                + " operations total, elapsed time = " + delta
                                + " (" + ops + " operations/sec");
}
}
