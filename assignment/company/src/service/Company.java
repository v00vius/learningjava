package service;

import dto.message.Response;
import entity.Department;
import entity.Employee;

import java.util.Map;

public class Company {
private Map<String, Department> departments;
private Map<Integer, Employee> employees;

public Company(Map<String, Department> departments, Map<Integer, Employee> employees)
{
        this.departments = departments;
        this.employees = employees;
}

public Response newEmployee(String firstName, String lastName, String jobPosition, String department)
{
        return null;
}
public Response dismissEmployee(Integer id)
{
        return null;
}
public Response newDepartment(String name)
{
        return null;
}
public Response deleteDepartment(String name)
{
        return null;
}
public Response setDepartment(Integer employeeId, String department)
{
        return null;
}
}
