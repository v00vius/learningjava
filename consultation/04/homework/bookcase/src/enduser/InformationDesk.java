package enduser;

import java.util.Arrays;

import types.Book;
import types.BookCase;
import service.BookCaseService;
import service.Printer;
import utils.*;

public class InformationDesk {
        private String name;
        private BookCase bookCase;
        private BookCaseService bookCaseService;
        private Menu menu;
        private Printer printer;

        public InformationDesk(String name)
        {
                this.name = name;
                bookCaseService = new BookCaseService();
                bookCase = bookCaseService.createBookCase(5, 2);
                menu = new Menu(this.name);

                menu.add(
                        new String[]{
                                "Information about Bookcase",
                                "Get the Bookcase initially filled",
                                "Add Book",
                                "Take Book",
                                "Swap Books",
                                "Move Book to Shelf ...",
                                }
                );

                printer = new Printer();
        }

        public void informationDesk()
        {

                while (true) {
                        int selection = menu.show()
                                .select();

                        switch (selection) {
                        case 1:
                                getInformation();
                                break;

                        case 2:
                                initialFill();
                                break;

                        case 3:
                                addBook();
                                break;
                        case 4:
                                takeBook();
                                break;
                        case 5:
                                swapBooks();
                                break;
                        case 6:
                                moveBookToShelf();
                                break;

                        default:
                                System.out.println("Have a nice day! Bye!");
                                return;
                        }
                }//while
        }

        public void getInformation()
        {
                printer.printShelves(bookCase);
        }

        private void moveBookToShelf()
        {
                UserInterface ui = new UserInterface();

                Book book = askBookToTake("Which shelf do you want to take the book from? ",
                        "Which index do you want to take the book from? ");

                if (isEmptyBook(book)) {
                        System.out.println("That slot is  empty. Cannot take the book.");
                        return;
                }

                int shelf = ui.getInt("Which shelf do you want to move the book to? ");

                if (!isValidIndex(shelf, 0)) {
                        System.out.println("Invalis shelf. Cannot move the book.");
                        return;
                }

                printer.print(book);
                System.out.println(" is being moved to shelf " + shelf + ".");
                bookCaseService.moveBookToShelf(bookCase, shelf, book);
        }

        private void swapBooks()
        {
                System.out.println("It's not implemented yet");
        }

        private boolean isEmptyBook(Book book)
        {
                return book.getId() == 0
                       && book.getTitle().equals("")
                       && book.getAuthor().equals("");
        }

        private Book getEmptyBook()
        {
                return new Book(0, "", "");
        }

        private boolean isValidIndex(int shelf, int index)
        {
                return 0 <= shelf && shelf < bookCase.getNumberOfShelves()
                       && 0 <= index && index < bookCase.getBooksPerShelf();
        }

        private Book askBookToTake(String question1, String question2)
        {
                UserInterface ui = new UserInterface();

                int shelf = ui.getInt(question1);

                if (!isValidIndex(shelf, 0)) {
                        return getEmptyBook();
                }

                int index = ui.getInt(question2);

                if (!isValidIndex(shelf, index)) {
                        return getEmptyBook();
                }

                return bookCaseService.getBookAt(bookCase, shelf, index);
        }

        private void takeBook()
        {
                Book book = askBookToTake("Which shelf do you want to take the book from? ",
                        "Which index do you want to take the book from? ");

                if (isEmptyBook(book) || !bookCaseService.takeBook(bookCase, book)) {
                        System.out.println("That book is not available.");
                        return;
                }

                System.out.println("Thank you for taking the book:");
                printer.print(book);
                System.out.println("\n");
        }

        private void addBook()
        {
                UserInterface ui = new UserInterface();
                String title = ui.getString("Which title of the book do you want to add? ");
                String author = ui.getString("Which author of the book do you want to add? ");
                Book book = new Book(0, title, author);

                if (isEmptyBook(book)) {
                        System.out.println("That book is not valid.");
                        return;
                }

                book.setId(1 + bookCase.getCounts());
                bookCaseService.setBook(bookCase, book);
        }

        private void initialFill()
        {
                bookCaseService.setBook(bookCase, new Book(10, "C++ Concurrency in Action: Practical Multithreading",
                        "Anthony Williams"));

                bookCaseService.setBook(bookCase, new Book(20, "Java For Dummies", "Barry A. Burd"));
                bookCaseService.setBook(bookCase, new Book(30, "Effective Java", "Joshua Bloch"));
                bookCaseService.setBook(bookCase, new Book(40, "The Art of Multiprocessor Programming", "Maurice Herlihy"));
        }
}
