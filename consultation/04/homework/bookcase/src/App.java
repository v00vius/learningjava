import java.util.Arrays;

import entity.Book;
import entity.BookCase;
import service.BookCaseService;
import service.Printer;

class App {
    public static void main(String[] args) {
        Book book1 = new Book(10, "C++ Concurrency in Action: Practical Multithreading",
                "Anthony Williams");
        Book book2 = new Book(20, "Java For Dummies", "Barry A. Burd");
        Book book3 = new Book(30, "Effective Java", "Joshua Bloch");
        Book book4 = new Book(40, "The Art of Multiprocessor Programming", "Maurice Herlihy");

        BookCaseService service = new BookCaseService();
        BookCase bookCase = service.createBookCase(4, 2);

        service.setBook(bookCase, book1);
        service.setBookOnShelf(bookCase, 1, book2);
        service.setBookOnShelf(bookCase, 3, book4);
        service.setBookOnShelf(bookCase, 3, book3);

        Printer printer = new Printer();

        printer.print(bookCase);

        service.swapBooks(bookCase, book4, book3);
        printer.print(bookCase);

        service.moveBookToShelf(bookCase, 1, book4);
        service.moveBookToShelf(bookCase, 2, book2);
        printer.print(bookCase);
       
    }
}
