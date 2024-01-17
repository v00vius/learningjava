
public class App {

        public static void main(String[] args) throws Exception
        {
                Storage storage = new Storage(10);

                storage.addWord("apple");
                storage.addWord("banana");
                storage.addWord("cherry");
                storage.addWord("orange");

                storage.removeWord(0);
                storage.removeWord(2);

                System.out.println("Insetions: " + storage.getInsertions());
                System.out.println("Removals: " + storage.getRemovals());
                System.out.println("Counter: " + storage.getCounts());
        }
}
