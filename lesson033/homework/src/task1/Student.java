package task1;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Student {
private String name;
private int age;
private double advGrade;

public Student(String name, int age, double advGrade)
{
        this.name = name;
        this.age = age;
        this.advGrade = advGrade;
}

public String getName()
{
        return name;
}

public int getAge()
{
        return age;
}

public double getAdvGrade()
{
        return advGrade;
}

@Override
public String toString()
{
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", advGrade=" + advGrade +
                '}';
}

static public class StudentGenerator implements IntFunction<Student> {
        static private Random random = new Random(System.currentTimeMillis());

        @Override
        public Student apply(int value)
        {
                String aName = "Name" + value;
                int anAge = random.nextInt(18, 80);
                double aGrade = random.nextDouble(1., 10.);

                return new Student(aName, anAge, aGrade);
        }
}

public static void main(String[] args)
{
        IntFunction<Student> createStudent = new StudentGenerator();
        List<Student> students0 = IntStream.range(1, 20)
                .mapToObj(createStudent)
                .toList();

        //--- task 1
        List<Student> students = students0.stream()
                .filter(s -> s.getAge() > 40)
                .filter(s -> s.getAdvGrade() > 4.5)
                .toList();

        System.out.println("count=" + students.size() +  "\n" + students);

        //--- task 4
        List<Student> byYear = students0.stream()
                .filter(s -> s.getAdvGrade() > 4.5)
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();

        System.out.println("By year\n" + byYear);
}
}
