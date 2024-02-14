package persistent;

public class Person {
private String name;
private String last_name;
private int age;
private String occupation;

public Person(String name, String last_name, int age, String occupation)
{
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.occupation = occupation;
}

@Override
public String toString()
{
        return "Person{" +
               "name='" + name + '\'' +
               ", last_name='" + last_name + '\'' +
               ", age=" + age +
               ", occupation='" + occupation + '\'' +
               '}';
}

}
