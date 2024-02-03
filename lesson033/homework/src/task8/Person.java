package task8;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Person {
private String name;
private int age;
private String gender;
private double salary;

public Person(String name, int age, String gender, double salary)
{
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
}
static public class PersonFactory implements IntFunction<Person> {
        static Random random = new Random(System.currentTimeMillis());
        static String[] genderList = {"M", "F", "*"};

        @Override
        public Person apply(int value)
        {
                String aName = "Name" + value;
                int anAge = random.nextInt(18, 80);
                String aGender = genderList[random.nextInt(3)];

                return new Person(aName, anAge, aGender,
                        random.nextDouble(40_000., 90_000.));
        }
}

public String getName()
{
        return name;
}

public int getAge()
{
        return age;
}

public String getGender()
{
        return gender;
}

public double getSalary()
{
        return salary;
}

@Override
public String toString()
{
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
}

public static void main(String[] args)
{
        PersonFactory newPerson = new PersonFactory();
        List<Person> persons = IntStream.range(1, 100)
                .mapToObj(newPerson)
                .toList();

        System.out.println(persons);
        System.out.println("#--------------------------------");

        double avgSalary =  persons.stream()
                .filter(p -> p.getGender().equals("M")
                        && p.getAge() >= 25
                        && p.getAge() <= 40)
                .mapToDouble(Person::getSalary)
                .average()
                .orElse(0.);

        System.out.println("avg salary " + avgSalary);
}
}
