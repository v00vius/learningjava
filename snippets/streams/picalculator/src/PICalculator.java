import java.util.function.LongToDoubleFunction;
import java.util.stream.LongStream;

//
// https://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80
//
public class PICalculator {
private long taskSize;

public PICalculator(long taskSize)
{
        this.taskSize = taskSize;
}

public double getPiOldSchool()
{
        double sum = 0.;
        double sign = -1.;

        for (long i = 1; i < taskSize; ++i) {
                if( (i & 0x01) == 0)
                        continue;

                sign = 0. - sign;
                sum += sign / (double) i;
        }

        return 4. * sum;
}
private class Long2Double implements LongToDoubleFunction {
private double sign = -1.;

@Override
public double applyAsDouble(long value)
{
        sign = 0. - sign;

        return sign / (double) value;
}
}
public double getPiStreams()
{
        LongToDoubleFunction calc = new Long2Double();

        double sum = LongStream.range(1, taskSize)
                .filter(i -> (i & 0x01) == 1)
                .mapToDouble(calc)
                .sum();

        return 4. * sum;
}

public long getTaskSize()
{
        return taskSize;
}

}
