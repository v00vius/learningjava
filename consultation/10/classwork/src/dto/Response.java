package dto;

public class Response <T> {
private boolean success;
private T data;
private String message;

public Response(boolean success, T data, String message)
{
    this.success = success;
    this.data = data;
    this.message = this.success ? "Ok" : message;
}

public T getData()
{
    return data;
}

public String getMessage()
{
    return message;
}
public boolean isSuccess()
{
    return success;
}

@Override
public String toString()
{
    return "Response{" +
            "success=" + success +
            ", data=" + data +
            ", message='" + message + '\'' +
            '}';
}
}
