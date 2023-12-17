package service;

import entity.BookCase;

public class Printer {
    public void print(BookCase bookCase) {
        for (int i = 0; i < bookCase.getNumberOfShelves(); ++i) {
            System.out.println("Shelf " + (i + 1));

            for (int j = 0; j < bookCase.getBooksPerShelf(); ++j) {
                if(bookCase.isEmpty(i, j))
                    continue;

                System.out.println("  " + (j + 1) + " - " + bookCase.getBookAt(i, j));
            }
        }
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}
