package repo;

import entity.Employee;
import entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
private Map<Integer, Employee> employees;

public EmployeeManager()
{
        this.employees = new HashMap<>();
}
public Employee insert(String firstName, String lastName, String jobPosition)
{
        Employee emp = new Employee(Entity.newId(), firstName, lastName, jobPosition);

        employees.put(emp.getId(), emp);

        return emp;
}

public Collection<Employee> getEmployees()
{
        return employees.values();
}

public Employee delete(Integer id)
{
        Employee emp = employees.remove(id);

        return emp;
}
public Employee select(Integer id)
{
        return employees.get(id);
}

@Override
public String toString()
{
        return "EmployeeManager{" +
                "employees=" + employees +
                '}';
}
}
