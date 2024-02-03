public class Telemetry {
private final int loopCount;
private double baseOps;

public Telemetry(int loopCount)
{
        this.loopCount = loopCount;
        baseOps = 0.0;
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

        if(baseOps == 0.0)
                baseOps = ops;

        double difference = 100.0 * (ops - baseOps) / baseOps;

        System.out.println("Test: " + testName + ", " + loopCount
                                + " operations total, elapsed time = " + delta
                                + " (" + ops + " operations/sec, "
                                + difference + "% difference"
        );
}
}
