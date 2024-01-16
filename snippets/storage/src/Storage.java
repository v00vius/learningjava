import utils.Counter;

public class Storage extends Counter {
    private String[] words;

    public Storage(int size) {
        super();
        words = new String[size];
    }

    public boolean addWord(String word) {
        int index = findEmplyCell();

        if(-1 == index)
            return false;

        words[index] = word;
        incrementInsertionCount();

        return true;            
    }
    public boolean isFull() {
        return findEmplyCell() ==  -1;
    }

     public String removeWord(int index) { 
        String oldString = words[index];

        words[index] = null;
        incrementRemovalCount();

        return oldString;
    }

    private int findEmplyCell() {
        for (int i = 0; i < words.length; ++i) {
            if(words[i] == null)
                return i;
        }

        return -1;
    }
}
