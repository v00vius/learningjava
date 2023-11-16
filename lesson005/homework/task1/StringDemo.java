package task1;

public class StringDemo {
    private String data;

    public String getData() {
        return data;
    }

    public StringDemo(String data) {
        this.data = data;
    }

    public char getLastChar() {
        return data.charAt(data.length() - 1);
    }

    public boolean hasString(String stringToFind) {
        return data.contains(stringToFind);
    }

    public String  substituteChar( char from, char to) {
        data = data.replace(from, to);

        return getData();
    }

    public String toLower() {
        data = data.toLowerCase();

        return getData();
    }

    public String toUpper() {
        data = data.toUpperCase();

        return getData();
    }

    public String removeSubString(String whatToRemove) {
        int begin = data.indexOf(whatToRemove);
        int end = begin + whatToRemove.length();

        // In the real world we should check if we
        // have found or not a string "whatToRemove"
        // and check boundaries
        data = data.substring(0, begin) + data.substring(end);

        return getData();
    }

    public static void main(String[] args) {
        // Steps 1, 2
        String      basicJava = "I study Basic Java!";
        StringDemo  test1 = new StringDemo(basicJava);

        System.out.println("# Teask 1");
        // Step 3.
        System.out.println("The last char of the \"" + test1.getData()
                        + "\" is '" + test1.getLastChar() + "'"
        );

        // Step 4.
        System.out.println("Does the \"" + test1.getData()
                        + "\" contain \"Java\"? " + test1.hasString("Java")
        );

        // Step 5.

        System.out.println("I've substituted all occurrences of the 'a' to 'o': \""
                + test1.substituteChar('a', 'o') + "\""
        );

        // Step 6.
        System.out.println("UPPER case: \"" + test1.toUpper() + "\"" );

        // Step 7.
        System.out.println("lower case: \"" + test1.toLower() + "\"" );

        // Step 8.
        StringDemo test2 = new StringDemo("I study Basic Java!");
        System.out.println("\"Java\" has been removed from \"" + test2.getData() + "\": \""
                + test2.removeSubString("Java") + "\"" );

    }
}
