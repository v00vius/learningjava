package task1;

public class Status {
public static final int OK = 0;
public static final int ERROR = -1;
private int rc;
private Object data;
private String message;

public Status(int rc, Object data, String message)
{
        this.rc = rc;
        this.data = data;
        this.message = message;
}

public boolean isOk()
{
        return rc == OK;
}
public boolean isError()
{
        return rc == ERROR;
}

public String getMessage()
{
        return message;
}

@Override
public String toString()
{
        return "Status{" +
               "rc=" + rc +
               ", data=" + data +
               ", message='" + message + '\'' +
               '}';
}
}
