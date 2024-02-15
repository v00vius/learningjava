package persistent;

public class Person {
private int id;
private String name;
private String lastName;
private int age;
private String occupation;

public Person(int id, String name, String lastName, int age, String occupation)
{
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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

public int getId()
{
        return id;
}

public void setId(int id)
{
        this.id = id;
}

public void setLastName(String lastName)
{
        this.lastName = lastName;
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

public String getLastName()
{
        return lastName;
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
               "id=" + id +
               ", name='" + name + '\'' +
               ", last_name='" + lastName + '\'' +
               ", age=" + age +
               ", occupation='" + occupation + '\'' +
               "}\n";
}
}
