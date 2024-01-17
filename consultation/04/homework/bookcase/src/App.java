import java.util.Arrays;

import enduser.InformationDesk;
import types.Book;
import types.BookCase;
import service.BookCaseService;
import service.Printer;

class App {
        public static void main(String[] args)
        {

                InformationDesk informationDesk = new InformationDesk("BookCase Information Desk");


                informationDesk.informationDesk();
/* 
        Book book1 = new Book(10, "C++ Concurrency in Action: Practical Multithreading",
                "Anthony Williams");
        Book book2 = new Book(20, "Java For Dummies", "Barry A. Burd");
        Book book3 = new Book(30, "Effective Java", "Joshua Bloch");
        Book book4 = new Book(40, "The Art of Multiprocessor Programming", "Maurice Herlihy");

        BookCaseService service = new BookCaseService();
        BookCase bookCase = service.createBookCase(4, 2);

        service.setBook(bookCase, book1);
        service.setBookOnShelf(bookCase, 1, book2);
        service.setBookOnShelf(bookCase, 2, book4);
        service.setBookOnShelf(bookCase, 3, book3);

        Printer printer = new Printer();

        printer.print(bookCase);
        service.swapBooks(bookCase, book4, book3);
        printer.print(bookCase);

        if(!service.moveBookToShelf(bookCase, 0, book4)) {
            System.out.print(">>> Failed to move ");
            printer.print(book4);
            System.out.println(" to the shelf 0");
        }

        if(!service.moveBookToShelf(bookCase, 0, book2)) {
            System.out.print(">>> Failed to move ");
            printer.print(book2);
            System.out.println(" to the shelf 0");

        }

        printer.print(bookCase);
*/
        }
}
