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
public String getError(int id)
{
        return properties.get("/errors", id);
}
public int addError(String description)
{
        int ec = getErrorCount();

        properties.set("/errors", ec, description);
        properties.set("/errors", ++ec);

        return ec;
}
public boolean isEmpty()
{
        return 0 == getErrorCount();
}
@Override
public String toString()
{
        StringBuilder sb = new StringBuilder("Errors\n");

        for(int i = 0, n = getErrorCount(); i < n; ++i) {
                String errorDescription = getError(i);

                sb.append("  ").append(i).append(") ").append(errorDescription).append('\n');
        }

        return sb.toString();
}
}
