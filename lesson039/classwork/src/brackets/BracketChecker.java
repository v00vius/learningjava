package brackets;

import java.util.Stack;

public class BracketChecker {
private Brackets brackets;

public BracketChecker(String allowedBrackets)
{
        this.brackets = new Brackets(allowedBrackets);
}

public int checkBrackets(String str)
{
        Stack<Integer> chars = new Stack<>();

        for (int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                int id = brackets.getBracketID(ch);

                if(id == Brackets.NOT_BRACKET)
                        continue;

                if(brackets.isOpening(id)) {
                        chars.push(id);
                } else if (brackets.isClosing(id)) {
                        if(chars.isEmpty())
                                return i + 1;

                        int id1 = chars.pop();

                        if(!brackets.isMatching(id1, id))
                                return i + 1;
                }
        }

        return chars.isEmpty() ? 0 : str.length();
}
}
