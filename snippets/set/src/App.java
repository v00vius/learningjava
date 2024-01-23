import java.util.HashSet;
import java.util.Set;

public class App {

public static void main(String[] args) throws Exception
{
        Set<Element> elements = new HashSet<>();

        for (int i = 0; i < 10; i++) {
                elements.add(new Element(i + 10));
        }

        System.out.println(elements);

        boolean exists = elements.contains(new Element(10));
        System.out.println(exists);
}
}
