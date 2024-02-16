package brackets;

public class App {
public static void main(String[] args)
{
        BracketChecker checker = new BracketChecker("({[<>]})");
        String[] patternts = {
                "",
                "()",
                "([{}])",
                "()()()",
                "({[]])",
                ")([{({[{{[[(( ))]]}}]}])"
        };

        for (String s : patternts) {
                int rc = checker.checkBrackets(s);

                if (rc == 0)
                        System.out.println("Test: \"" + s + "\"\n  >Ok");
                else {
                        System.out.println(String.format("Test: \"%s\"\n  >Error: the unmatched bracket at the position %d",
                                s, rc)
                        );
                }
        }
}
}
