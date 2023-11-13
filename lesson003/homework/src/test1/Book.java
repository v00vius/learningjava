package test1;

public class Book {
    private String name;
    private String writtenBy;
    private int pages;
    private int id;
    private boolean available;

    public Book(String name, String writtenBy, int pages, int id, boolean available) {
        this.name = name;
        this.writtenBy = writtenBy;
        this.pages = pages;
        this.id = id;
        this.available = available;
    }

    public Book(String name, String writtenBy) {
        this.name = name;
        this.writtenBy = writtenBy;
    }

    public void print() {
        System.out.println("\nThe info of a book:");
        System.out.println("\tBook name: " + name
                        + "\n\tBook ID: " + id
                        + "\n\tBy: " + writtenBy
                        + "\n\tNumber of pages: " + pages
                        + "\n\tIs available (in the library): " + (available ? "Yes" : "No")
        );
    }
    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Book setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    static public Book newBook(String name, String writtenBy) {
        return new Book(name, writtenBy);
    }

    static public Book newBook(String name, String writtenBy, int pages, int id, boolean available) {
        return new Book(name, writtenBy, pages, id, available);
    }


    public static void main(String[] args) {
        Book book1 = Book.newBook("Java For Dummies", "Barry A. Burd",
                            434, 9175690, true);

        Book book2 = Book.newBook("Effective Java", "Joshua Bloch");

        book2.setPages(416)
                .setId(4685997)
                .setAvailable(true);

        book1.print();
        book2.print();
    }
}
