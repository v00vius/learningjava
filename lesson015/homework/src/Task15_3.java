import utils.UserInterface;

public class Task15_3 {
    public String[] splitLine(String line) {
        line = line.trim();

        if(line.isEmpty())
            return new String[0];

        DynamicStringArray strings = new DynamicStringArray();
        int wordBeginIndex = 0;

        while(wordBeginIndex < line.length()) {
            int wordEndIndex = findBlanks(line, wordBeginIndex);
            String word = line.substring(wordBeginIndex, wordEndIndex);

            strings.add(word);
            wordBeginIndex = skipBlanks(line, wordEndIndex);
        }

        return strings.getData();
    }
    private int skipBlanks(String str, int index) {
        for (int i = index; i < str.length(); i++) {
            if(!isBlank(str.charAt(i)))
                return i;
        }

        return str.length();
    }
    private int findBlanks(String str, int index) {
        for (int i = index; i < str.length(); i++) {
            if(isBlank(str.charAt(i)))
                return i;
        }

        return str.length();
    }
    boolean isBlank(int ch) {
        return (ch == ' ' || ch == '\t');
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.message("Please, type words. Blank line to exit\n");
        DynamicStringArray words = new DynamicStringArray();
        Task15_3 wordCounter = new Task15_3();

        while (true) {
            String line = ui.getString();

            if(line.isEmpty())
                break;

            String[] wordsInLine = wordCounter.splitLine(line);

            words.add(wordsInLine);
            ui.message("Already have entered " + words.getSize() + " word(s)\n");
        }

        ui.message("Total have entered " + words.getSize() + " word(s)\nBye!\n");
    }
}
