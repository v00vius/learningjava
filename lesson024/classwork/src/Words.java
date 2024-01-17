import java.util.HashMap;
import java.util.Map;

public class Words {
        private Map<Character, String> wordsMap;

        public Words()
        {
                wordsMap = new HashMap<>();
        }

        public boolean add(String s)
        {
                if (s.isEmpty()) {
                        return false;
                }

                Character ch = s.charAt(0);

                wordsMap.put(ch, s);

                return true;
        }

        @Override
        public String toString()
        {
                return "Words{" +
                       "wordsMap=" + wordsMap +
                       '}';
        }

        public static void main(String[] args)
        {
                Words words = new Words();
                String[] strings = new String[]{
                        "public",
                        "class",
                        "Words",
                        "wordsMap",
                        "Character",
                        "String"

                };

                for (String s : strings) {
                        words.add(s);
                }

                System.out.println(words);
        }
}
