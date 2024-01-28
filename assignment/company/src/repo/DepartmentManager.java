package repo;

import entity.Department;
import entity.Employee;
import entity.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentManager {
private Map<String, Department> departments;

public DepartmentManager()
{
        departments = new HashMap<>();
}
public boolean insert(String name)
{
        Department dep = departments.get(name);

        if(dep != null)
                return false;

        dep = new Department(Entity.newId(), name);
        departments.put(dep.getName(), dep);

        return true;
}
public boolean insert(String departmentName, Employee employee)
{
        Department dep = departments.get(departmentName);

        if(dep == null)
                return false;

        List<Employee> employeesInDepartment = dep.getEmployees();

        employeesInDepartment.add(employee);
        employee.setDepartment(dep.getName());

        return true;
}

public Department delete(String name)
{
        return departments.remove(name);
}

public Department select(String name)
{
        return departments.get(name);
}

@Override
public String toString()
{
        return "DepartmentManager{" +
                "departments=" + departments +
                '}';
}
}
