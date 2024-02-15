package entity;

public class Magazine extends LibraryItem{

    private String issuedNumber;

    public Magazine(String title, String author, int year, String issuedNumber) {
        super(title, author, year);
        this.issuedNumber = issuedNumber;
    }

    public String getIssuedNumber() {
        return issuedNumber;
    }
}
