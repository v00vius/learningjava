package task2;

public class App {
public static void main(String[] args)
{
        BracketChecker checker = new BracketChecker("({[<>]})");
        String to_check = "[  {}   {}]<<({[[[  < >  ]]]})>>";
        int rc = checker.checkBrackets(to_check);

        if (rc == 0)
                System.out.println("\"" + to_check + "\": Ok");
        else {
                System.out.println(String.format("\"%s\":\nError - unmatched bracket at position %d",
                        to_check, Math.abs(rc))
                );
        }
}
}
