package service;

import entity.BookCase;

public class InformationDesk {
//  User information desk
//      menu
//          set/take book, print contents of a bookcase, etc.)
    BookCase bookCase;
    BookCaseService bookCaseService;

    public InformationDesk() {
        bookCaseService = new BookCaseService();
    }

    public void informationDesk() {
        System.out.println("Information Desk");
        System.out.println("1. Set Book");
        System.out.println("2. Take Book");
        System.out.println("3. Print Bookcase");
        System.out.println("4. Swap Books");
        System.out.println("5. Move Book to Shelf");
        System.out.println("6. Move Book to Shelf");
        System.out.println("7. Exit");
    }
}
