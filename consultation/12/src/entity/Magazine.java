package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Magazine extends LibraryItem{

    private String issuedNumber;
    private List<Article> articles;
    private int published;

    public Magazine(String title, int year, String issuedNumber, int published) {
        super(title, year);
        this.issuedNumber = issuedNumber;
        this.articles = new ArrayList<>();
        this.published = published;
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public String getIssuedNumber() {
        return issuedNumber;
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issuedNumber='" + issuedNumber + '\'' +
                ", articles=" + articles + " published=" + published +
                '}';
    }
}
