package util;

import java.util.Scanner;

public class ConsoleIO {
private Scanner sc;

public ConsoleIO()
{
        sc = new Scanner(System.in);
}

public String gets()
{
        return sc.nextLine().trim();
}
public String gets(String prompt)
{
        puts(prompt);

        return gets();
}
public void puts(String s)
{
        System.out.print(s);
}
public int getInt()
{
        String s = gets();

        return s.isEmpty() ? 0 : Integer.parseInt(s);
}
public int getInt(String prompt)
{
        puts(prompt);

        return getInt();
}

public static void main(String[] args)
{
        ConsoleIO io = new ConsoleIO();

        int v = io.getInt("Int: ");

        io.puts("Value: " + v);;

}
}
