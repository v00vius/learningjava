package utils;

public class Vowel {
static public boolean isVowel(char ch)
{
        return "aeiou".indexOf(ch) != -1;
}

static public int countVowels(String s)
{
        var count = 0;

        for (char ch : s.toLowerCase().toCharArray()) {
                if(isVowel(ch))
                        ++count;
        }

        return count;
}
}
