import java.util.Objects;

public class Employee {
    static private int idCounter = 0;
    static private int getIdCounter() {
        return ++idCounter;
    }

    private int id;
    private String name;
    private String deparament;

    public Employee(String name, String department) {
        this.id = getIdCounter();
        this.name = name;
        this.deparament = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return deparament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "\nEmployee {\n" +
                "  id=" + id +
                "\n  name='" + name + '\'' +
                "\n  deparament='" + deparament + '\'' +
                "} ";
    }
}
