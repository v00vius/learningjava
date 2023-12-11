public class Task15_1 {
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

        Task15_1 task151 = new Task15_1();

        task151.println("Before:");
        task151.printStrings(strings);

        task151.println("After:");
        task151.reverse(strings);
        task151.printStrings(strings);
    }
}
