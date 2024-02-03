package task2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Strings {
public static void main(String[] args)
{
        //--- task2
        List<String> strings = new Random().ints(10)
                .mapToObj(i -> "str" + Integer.toString(i))
                .filter(s -> (s.length() & 0x01) == 1)
                .toList();

        System.out.println(strings);

        //--- task3
        String all = strings.stream()
                .collect(Collectors.joining("++"));
        System.out.println(all);
}
}
