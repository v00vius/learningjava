package task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Person {
private String name;
private int age;
private List<String> skills;

public Person(String name, int age)
{
        this.name = name;
        this.age = age;

        skills = new ArrayList<>();
}

public String getName()
{
        return name;
}

public int getAge()
{
        return age;
}

public List<String> getSkills()
{
        return skills;
}
public void addSkill(String skill)
{
        skills.add(skill);
}

@Override
public String toString()
{
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
}

static public class PersonGenerator implements IntFunction<Person> {
        static Random random = new Random(System.currentTimeMillis());

        @Override
        public Person apply(int value)
        {
                String aName = "Name" + value;
                int anAge = random.nextInt(18, 80);
                Person person = new Person(aName, anAge);

                for (int i = 0; i < 3; i++)
                        person.addSkill("Skill-" + random.nextInt(20));

                return person;
        }
}

public static void main(String[] args)
{
        PersonGenerator newPerson = new PersonGenerator();

        List<Person> persons = IntStream.range(1, 10)
                .mapToObj(newPerson)
                .toList();

        System.out.println(persons);

        //--- task 6
        List<String > skills = persons.stream()
                .filter(p -> p.getAge() > 25)
                .flatMap(p -> p.getSkills().stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println("skills " + skills);
}
}
