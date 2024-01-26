package dto;

public interface Message {
boolean setProperty(String name, String value);
String getProperty(String name);
String getTag();
int getErrorCode();
void setErrorCode(int ec);
}
