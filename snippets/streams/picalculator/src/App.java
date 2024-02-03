public class App {
public static void main(String[] args)
{
        PICalculator calc = new PICalculator(100_000_000L);

        System.out.println("Task size = " + calc.getTaskSize() + " pi = " + calc.getPiOldSchool());
        System.out.println("Task size = " + calc.getTaskSize() + " pi = " + calc.getPiStreams());

        Telemetry telemetry = new Telemetry(31);

        telemetry.test("Old school", calc::getPiOldSchool);
        telemetry.test("Streams", calc::getPiStreams);
}
}
