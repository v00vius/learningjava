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

public Person()
{
}

public void setName(String name)
{
        this.name = name;
}

public void setLast_name(String last_name)
{
        this.last_name = last_name;
}

public void setAge(int age)
{
        this.age = age;
}

public void setOccupation(String occupation)
{
        this.occupation = occupation;
}

public String getName()
{
        return name;
}

public String getLast_name()
{
        return last_name;
}

public int getAge()
{
        return age;
}

public String getOccupation()
{
        return occupation;
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
