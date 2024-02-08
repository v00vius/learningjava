import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validator {
private Map<String, String> properties;
private List<String> errors;
private List<Checker> checks;

public Validator(Map<String, String> properties, List<Checker> checks)
{
        this.properties = properties;
        this.checks = checks;
        errors = new ArrayList<>();
}

List<String> validate()
{
        for (Checker checker : checks) {
                List<String> e = checker.check(properties);

                errors.addAll(e);
        }

        return errors;
}
}
