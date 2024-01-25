package service;

import dto.message.Message;
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

public Message newEmployee(String firstName, String lastName, String jobPosition, String department)
{
        return null;
}
public Message dismissEmployee(Integer id)
{
        return null;
}
public Message newDepartment(String name)
{
        return null;
}
public Message deleteDepartment(String name)
{
        return null;
}
public Message setDepartmentForEmployee(Integer employeeId, String department)
{
        return null;
}
public Message getEmployeesOfDepartment(String name)
{
        return null;
}
}
