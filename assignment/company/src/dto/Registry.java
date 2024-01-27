package dto;

public interface Registry {
String getTag();
void setTag(String tag);
void setTag();

boolean exists(String key);
boolean exists(String key, int index);

boolean set(String key, String value);
boolean set(String key, int index, String value);

boolean set(String key, int value);
boolean set(String key, int index, int value);

boolean set(String key, double value);
boolean set(String key, int index, double value);

String get(String key);
String get(String key, int index);

int getInt(String key);
int getInt(String key, int index);
double getDouble(String key);
double getDouble(String key, int index);

int getErrorCode();
void setErrorCode(int ec);
}
