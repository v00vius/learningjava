package utils;

public class Utils {
    public static void fatalExit(String s) {
        System.err.println(s);
        System.exit(1);
    }
    public static int fromFahrenheit2Celsius(int tempF){
        return 5 * (tempF - 32) / 9;
    }
}
