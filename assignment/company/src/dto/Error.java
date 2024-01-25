package dto;

public class Error {
private final ErrorCode ec;
private final String description;

public Error(ErrorCode ec, String description)
{
        this.ec = ec;
        this.description = description;
}

public ErrorCode getErrorCode()
{
        return ec;
}

public String getDescription()
{
        return description;
}

@Override
public String toString()
{
        return "Error{" +
               "ec=" + ec +
               ", description='" + description + '\'' +
               '}';
}
}
