package enduser;

import java.util.Arrays;

import entity.Book;
import entity.BookCase;
import service.BookCaseService;
import service.Printer;
import utils.*;

public class InformationDesk {
    private String name;
    private BookCase bookCase;
    private BookCaseService bookCaseService;
    private Menu menu;
    private Printer printer;

    public InformationDesk(String name){
        this.name = name;
        bookCaseService = new BookCaseService();
        bookCase = bookCaseService.createBookCase(5, 2);
        menu = new Menu(this.name);

        menu.add(
            new String[] {
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

    public void informationDesk() {
        
        while(true) {
            int selection = menu.show()
                                .select();

            switch(selection) {
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
    public void getInformation() {
        printer.printShelves(bookCase);
    }

    private void moveBookToShelf() {
        System.out.println("It's not implemented yet");
    }

    private void swapBooks() {
        System.out.println("It's not implemented yet");
    }

    private boolean isEmptyBook(Book book) {
        return book.equals(getEmptyBook());
    }
    private Book getEmptyBook() {
        return new Book(0, "", "");
    }
    private Book askBook() {
        UserInterface ui = new UserInterface();

        int shelf = ui.getInt("Which shelf do you want to take the book from? ");

        if(0 > shelf || shelf >= bookCase.getNumberOfShelves()) 
            return getEmptyBook();

        int index = ui.getInt("Which index do you want to take the book from? ");

        if(0 > index || index >= bookCase.getBooksPerShelf()) 
            return getEmptyBook();

        return bookCaseService.getBookAt(bookCase, shelf, index);
    }
    private void takeBook() {
        Book book = askBook();

        if(isEmptyBook(book) || !bookCaseService.takeBook(bookCase, book)) {
            System.out.println("That book is not available.");
            return;
        }

        System.out.println("Thank you for taking the book:");
        printer.print(book);
        System.out.println("\n");
    }

    private void addBook() {
        System.out.println("It's not implemented yet");
    }

    private void initialFill() {
        bookCaseService.setBook(bookCase, new Book(10, "C++ Concurrency in Action: Practical Multithreading",
                "Anthony Williams"));

        bookCaseService.setBook(bookCase, new Book(20, "Java For Dummies", "Barry A. Burd"));
        bookCaseService.setBook(bookCase, new Book(30, "Effective Java", "Joshua Bloch"));
        bookCaseService.setBook(bookCase, new Book(40, "The Art of Multiprocessor Programming", "Maurice Herlihy"));
    }
}
