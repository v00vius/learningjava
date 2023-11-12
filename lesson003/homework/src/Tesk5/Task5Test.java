package Tesk5;

public class Task5Test {
    public static void main(String[] args) {
        Remainder div3loop14 = new Remainder(3, 14);
        Remainder div2loop10 = new Remainder(2, 10);

        div3loop14.doAll();
        div2loop10.doAll();

        int x = 3;

        x += x++;
        System.out.printf("\nResult of the 'x += x++' where x = 3 is x = %d\n", x);
// Java gives result x = 6
// C++ gives result x = 7
/*
#include <iostream>

int main(int ac, char* av[])  {
        int x = 3;

        x += x++;

        std::cout << "Result of the x += x++ where x = 3 is " << x << std:: endl;
}
*/
    }
}
