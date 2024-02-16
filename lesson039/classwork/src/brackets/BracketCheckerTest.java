package brackets;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketCheckerTest {
BracketChecker checker = new BracketChecker("({[<>]})");
String[] patterns = {
        "",
        "()",
        "([{}])",
        "()()()",
        "({[]])",
        ")([{({[{{[[(( ))]]}}]}])"
};

int[] expected = {
        0,
        0,
        0,
        0,
        5,
        1
};

@Test
public void checkBrackets()
{
        for (int i = 0; i < patterns.length; i++) {
                int actual = checker.checkBrackets(patterns[i]);

                System.out.println("Test: '" + patterns[i] + "'");
                assertEquals(expected[i], actual);
        }
}
}