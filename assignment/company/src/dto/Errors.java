package dto;

public class Errors {
private Registry properties;

public Errors(Registry properties)
{
        this.properties = properties;

}
public int getErrorCount()
{
        return properties.exists("/errors") ? properties.getInt("/errors") : 0;
}
private void updateErrorCount()
{
        int ec = getErrorCount();

        properties.set("/errors", ++ec);
}
public String getError(int id)
{
        return properties.get("/errors", id);
}
public Errors setError(int id, String description)
{
        properties.set("/errors", id, description);
        updateErrorCount();

        return this;
}
public boolean hasErrors()
{
        return 0 == getErrorCount();
}
@Override
public String toString()
{
        StringBuilder sb = new StringBuilder("\n### Errors\n");

        for(int i = 1, n = getErrorCount(); i <= n; ++i) {
                String errorDescription = getError(i);

                sb.append("  ").append(i).append(") ").append(errorDescription).append('\n');
        }

        return sb.toString();
}
}
