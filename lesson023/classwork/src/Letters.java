import java.util.ArrayList;
import java.util.LinkedList;


public class Letters {
    private ArrayList<XChar> alphabet;

    public Letters() {
        alphabet = new ArrayList<>(32);

        for(Character ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(new XChar(ch));
        }
    }

    public void doAll() {
        alphabet.forEach(XChar::add);
    }

    public String getAlphabet() {
        String str = "";

        for (int i = 0; i < alphabet.size(); ++i) {
            str += alphabet.get(i);
        }

        return str;
    }

    public String getReverseAlphabet() {
        String str = "";

        for (int i = alphabet.size() - 1; i >= 0; --i) {
            str += alphabet.get(i);
        }

        return str;
    }

    public static void main(String[] args) {
        Letters letters = new Letters();

        letters.doAll();
//        String directOrder = letters.getAlphabet();
//        String reverseOrder = letters.getReverseAlphabet();
//
//        System.out.println("Alphabet: \"" + directOrder + "\"");
//        System.out.println("Alphabet, reverse: \"" + reverseOrder+ "\"");
    }
}
