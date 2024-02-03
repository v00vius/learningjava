import java.util.function.LongToDoubleFunction;
import java.util.stream.LongStream;

//
// The Leibniz formula for π:
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
                if(0 == (i & 0x01))
                        continue;

                sign = 0. - sign;
                sum += sign / (double) i;
        }

        return 4. * sum;
}
public double getPiStreams()
{
        double sum = LongStream.range(1, taskSize)
                .filter(i -> (i & 0x01) == 1)
                .mapToDouble(new LongToDoubleFunction() {
                        private double sign = -1.;

                        @Override
                        public double applyAsDouble(long value)
                        {
                                sign = 0. - sign;

                                return sign / (double) value;
                        }
                })
                .sum();

        return 4. * sum;
}

public long getTaskSize()
{
        return taskSize;
}
}
