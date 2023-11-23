import utils.UserInterface;

public class Array4 {
    static
    public boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(reverse(word));
    }
    static
    public String reverse(String string) {
        String reverseString = "";

        for(int i = string.length() - 1; i >= 0;  --i)
            reverseString += string.charAt(i);

        return reverseString;
    }
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        for(;;) {
            String w1 = ui.getString("Enter a word (empy to exit): ");

            if(w1.trim().isEmpty())
                break;

            System.out.println("The word \"" +w1 + "\" "
                    + (isPalindrome(w1) ? "is the palindrome" : "isn't the palindrome"));
        }

        System.out.println("Thanks, exiting");

    }
}
