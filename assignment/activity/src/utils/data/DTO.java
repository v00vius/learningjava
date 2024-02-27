package utils.data;

import java.util.UUID;
// The Key/Value carrier
public interface DTO {
        String get(String key);
        long getInt(String key);
        UUID getId(String key);
        DTO set(String key, String value);
        DTO set(String key, long value);
        DTO set(String key, UUID value);
        DTO fromString(String message);
        boolean exists(String key);
}
