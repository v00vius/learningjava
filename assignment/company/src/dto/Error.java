package dto;

public class Error {
private Message properties;

public Error(Message properties)
{
        this.properties = properties;
}
public String getError(int id)
{
        return properties.getProperty(key(id));
}
public Error setError(int id, String description)
{
        properties.setProperty(key(id), description);

        return this;
}
private String key(int id)
{
        return Keys.key(Keys.ERROR, id);
}
@Override
public String toString()
{
        StringBuilder sb = new StringBuilder(">>> Errors <<<\n");

        for(int i = 1;; ++i) {
                String errorDescription = properties.getProperty(key(i));

                if(errorDescription.isEmpty())
                        break;

                sb.append(i).append(") ").append(errorDescription).append('\n');
        }

        return sb.toString();
}
}
