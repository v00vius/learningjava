public class AvgCalc {
static public double getAverage(double[] numbers)
{
       var avg = 0.;

       for (var value : numbers)
               avg += value;

       return avg / numbers.length;
}
static public double getMax(double[] numbers)
{
        var aMax = numbers[0];

        for (var value : numbers) {
                if(value > aMax)
                        aMax = value;
        }

        return aMax;
}
}
