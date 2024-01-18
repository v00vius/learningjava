package task2;

public class Brackets {
private final String brackets;

static public final int NOT_BRACKET = -1;
public Brackets(String brackets)
{
        this.brackets = brackets;
}
public int getBracketID(char ch)
{
        for (int i = 0; i < brackets.length(); ++i) {
                char chx = brackets.charAt(i);

                if(chx == ch)
                        return i;

        }

        return NOT_BRACKET;
}

public boolean isOpening(int baracketID)
{
        return (baracketID < brackets.length() / 2 ) && baracketID != NOT_BRACKET;
}
public boolean isClosing(int baracketID)
{
        return (baracketID >= brackets.length() / 2 );
}
public boolean isMatching(int id1, int id2)
{
        return isOpening(id1) && isClosing(id2) && id1 == (brackets.length() -1 - id2);
}
}
