package dto;

public class Keys {
static public final String ERROR = "error/";
static public final String INFO = "info/";
static public final String ERROR_CODE = "errorCode";
static public String key(String keyName, int keyInstance)
{
        return keyName + keyInstance;
}
}
