package entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Department extends Entity {
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

        return 0 == getName().compareToIgnoreCase(that.getName());
}

@Override
public int hashCode()
{
        return getName().toUpperCase().hashCode();
}
}