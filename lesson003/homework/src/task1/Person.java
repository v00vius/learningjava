package task1;

public class Person {
    public Person(String name) {
        setName(name);;
    }
    public void print() {
        System.out.printf("My name is '%s'.\n", name());
        System.out.printf("I am %d years old.\n", age());
        System.out.printf("I am from '%s'.\n", place());
    }
//
//  set/getters
    String name() { return name; }
    void setName(String name) { this.name = name; }
    int age() { return age; }
    void setAge(int age) { this.age = age; }
    String place() { return place; }
    void setPlace(String place) { this.place = place;}
//
//  protected:
    protected String name;
    protected int age;
    protected String place;
}
