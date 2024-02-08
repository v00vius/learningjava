import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLoader {
private String fileName;
private List<Book> books;
public BookLoader(String fileName)
{
        this.fileName = fileName;
}

public List<Book> load() throws FileNotFoundException
{
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        List<String> lines = in.lines()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        books = new ArrayList<>();

        Map<String, String> properties = new HashMap<>();
        boolean found = false;

        for(String s : lines) {
                if (s.startsWith("{"))
                        found = true;

                if (found) {
                        if (-1 != s.indexOf('}'))
                                found = false;

                        s = s.replaceAll("[,{}]", "");
                        String[] pair = s.split(":");

                        String aKey = pair[0].trim();
                        String aValue = pair[1].trim();

                        properties.put(aKey, aValue);

                        if (!found) {
                                Book book = new Book(properties.get("Название книги"),
                                        properties.get("Автор"),
                                        Integer.parseInt(properties.get("год издания")));

                                books.add(book);
                                properties.clear();
                        }
                }
        }

        return books;
}

public static void main(String[] args) throws FileNotFoundException
{
        String fileName = "/home/vlan/tmp/books.txt";
        BookLoader bookLoader = new BookLoader(fileName);

        List<Book> books = bookLoader.load();

        System.out.println(books);
}
}
