import java.util.function.Function;

public class Test {
public static void main(String[] args)
{
        Function<String, String > func = String::toUpperCase;

        String s = func.apply("sssss");

        System.out.println(s);
}
}

