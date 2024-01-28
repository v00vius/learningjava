package entity;

import java.util.LinkedList;
import java.util.List;

public class Department extends Entity implements  Comparable<Department> {
private String name;
private List<Employee> employees;

public Department(int id, String name)
{
        super(id);

        this.name = name;
        this.employees = new LinkedList<>();
}

public String getName()
{
        return name;
}

public List<Employee> getEmployees()
{
        return employees;
}

@Override
public boolean equals(Object o)
{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return 0 == this.compareTo(that);
}

@Override
public int hashCode()
{
        return getName().toLowerCase().hashCode();
}

@Override
public String getText()
{
        return getName();
}

@Override
public String toString()
{
        return "Department{" +
               "name='" + name + '\'' +
               ", employees=" + employees +
               '}';
}

@Override
public int compareTo(Department d)
{
        return getName().compareToIgnoreCase(d.getName());
}
}
