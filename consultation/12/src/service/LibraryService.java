package service;

import entity.*;
import repository.BookRepository;
import repository.LibraryRepo;
import repository.MagazineRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryService {

    private LibraryRepo generalRepository = new LibraryRepo();
    private BookRepository bookRepository = new BookRepository();
    private MagazineRepository magazineRepository = new MagazineRepository();

    public void readFromFile(String filePath){
        try (Scanner scanner = new Scanner(new File(filePath)))
        {

                while (scanner.hasNextLine()) {
                    String type = scanner.nextLine().trim();

                    if (type.isEmpty()) continue;

                    String title = scanner.nextLine().trim();
                    int year = Integer.parseInt(scanner.nextLine().trim());

                    if (type.equalsIgnoreCase("Book")){
                        String author = scanner.nextLine().trim();
                        String genre = scanner.nextLine().trim();
                        var pages = Integer.parseInt(scanner.nextLine().trim());

                        Book newBook = new Book(title,year, author, genre, pages);
                        bookRepository.add(newBook);
                        generalRepository.add(newBook);

                    } else  if (type.equalsIgnoreCase("Magazine")){
                        String issuedNumber = scanner.nextLine().trim();
                        var published = Integer.parseInt(scanner.nextLine().trim());

                        Magazine newMagazine = new Magazine(title,year,issuedNumber, published);

                        while (scanner.hasNextLine()) {
                            String articleInfo = scanner.nextLine().trim();

                            if (articleInfo.isEmpty()) break;

                            String[] parts = articleInfo.split(":", 2);

                            if (parts.length == 2) {
                                newMagazine.addArticle(new Article(parts[0].trim(), parts[1].trim()));
                            }
                        }

                        magazineRepository.add(newMagazine);
                        generalRepository.add(newMagazine);
                    }
                }

    } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);}
    }


    public void printAll(){
        for (LibraryItem item : generalRepository.findAll()) {
            if (item instanceof Describable) {
                System.out.println( ((Describable) item).getDescribe());
            } else {
                Magazine itemMagazine = (Magazine) item;
                System.out.println("Magazine: " + itemMagazine.getTitle() + ", issued of " + itemMagazine.getYear() + " № " + itemMagazine.getIssuedNumber()) ;
            }
        }
    }

    public void printAllBooks(){
        for (Book book : bookRepository.findAll()) {
                System.out.println(book.getDescribe());
        }
    }

    public void printAllMagazines(){
        for (Magazine magazine : magazineRepository.findAll()) {
            System.out.println("Magazine: " + magazine.getTitle() + ", issued of " + magazine.getYear() + " № " + magazine.getIssuedNumber()) ;
            for (Article article : magazine.getArticles()) {
                System.out.println("- " + article.getAuthor() + " - " + article.getTitle());
            }
        }
    }

}
