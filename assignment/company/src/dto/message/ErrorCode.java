package dto.message;

public enum ErrorCode {
OK(200, "OK"),
BAD_REQUEST(400, "Bad Request"),
NOT_FOUND(404,"Not Found"),
INTERNAL_SERVER_ERROR(500, "Internal Server Error")
        ;
private final int code;
private final String info;

ErrorCode(int code, String info)
{
        this.code = code;
        this.info = info;
}

public int getCode()
{
        return code;
}

public String getInfo()
{
        return info;
}

@Override
public String toString()
{
        return "ErrorCode{" +
               "code=" + code +
               ", info='" + info + '\'' +
               '}';
}
}
