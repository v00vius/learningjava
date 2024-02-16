package brackets;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketCheckerTest {
BracketChecker checker = new BracketChecker("({[<>]})");
String[] patternts = {
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
        for (int i = 0; i < patternts.length; i++) {
                int actual = checker.checkBrackets(patternts[i]);

                System.out.println("Test: '" + patternts[i] + "'");
                assertEquals(expected[i], actual);
        }
}
}