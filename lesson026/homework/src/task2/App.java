package task2;

public class App {
public static void main(String[] args)
{
        BracketChecker checker = new BracketChecker("({[<>]})");
        String[] patternts = new String[] {
                "()",
                "([{}])",
                "()()()",
                "({[]])",
                ")([{({[{{[[(( ))]]}}]}])"
        };

        for (String s : patternts) {
                int rc = checker.checkBrackets(s);

                if (rc == 0)
                        System.out.println("\"" + s + "\": Ok");
                else {
                        System.out.println(String.format("\"%s\":\nError: the unmatched bracket at the position %d",
                                s, Math.abs(rc))
                        );
                }
        }
}
}
