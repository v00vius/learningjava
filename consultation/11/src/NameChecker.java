import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NameChecker implements Checker{
@Override
public List<String> check(Map<String, String> properties)
{
        List<String> errors = new ArrayList<>();

        String name = properties.get("Название книги");

        if(name == null) {
                errors.add("Error: The book name (key) not found");

                return errors;
        }

        if(name.isEmpty())
                errors.add("Error: the book name is empty");

        int len = name.length();

        if(len < 3)
                errors.add("Error: book name too short (must be >= 3)");

        if(len > 22)
                errors.add("Error: book name too long (must be < 22)");

        return errors;
}
}
