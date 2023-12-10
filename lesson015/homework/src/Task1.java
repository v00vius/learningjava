public class Task1 {
    public String[] reverse(String[] strings) {
        for (int i = 0; i < strings.length / 2; i++) {
            String tmp = strings[i];

            strings[i]  = strings[(strings.length - 1 - i)];
            strings[(strings.length - 1 - i)] = tmp;
        }

        return strings;
    }
    void printStrings(String[] strings) {
        println("Strings: " + strings.length + " element(s)");
        for (int i = 0; i < strings.length; i++) {
            println("  " + i + ") '" + strings[i] + "'");
        }
    }
    void println(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        String[] strings = {
                "Напишите программу,",
                "которая меняет местами",
                "элементы одномерного массива",
                "из String в обратном порядке.",
                "Не",
                "используйте дополнительный",
                "массив для",
                "хранения результатов."
        };

        Task1 task1 = new Task1();

        task1.println("Before:");
        task1.printStrings(strings);

        task1.println("After:");
        task1.reverse(strings);
        task1.printStrings(strings);
    }
}
