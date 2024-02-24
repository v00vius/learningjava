package utils.data;
// The Mapper interface is for data exchange,
// storage and so on
public interface Mapper<T> {
        // From a string representation it creates an object of type T
        T mapToObject(String str);
        // From an object of type T it creates a string representation
        // of the given object
        String mapToString(T object);
}
