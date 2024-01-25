package service;

import dto.message.Message;
import entity.Department;
import entity.Employee;
import repo.DepartmentManager;
import repo.EmployeeManager;

import java.util.Map;

public class ABCompany implements Company {
private String name;
private DepartmentManager departments;
private EmployeeManager employees;
public ABCompany(String name, DepartmentManager departments, EmployeeManager employees)
{
        this.name = name;
        this.departments = departments;
        this.employees = employees;
}

@Override
public Message newEmployee(String firstName, String lastName, String jobPosition, String department)
{
        return null;
}

@Override
public Message dismissEmployee(Integer id)
{
        return null;
}

@Override
public Message newDepartment(String name)
{
        return null;
}

@Override
public Message deleteDepartment(String name)
{
        return null;
}

@Override
public Message setDepartmentForEmployee(Integer employeeId, String department)
{
        return null;
}

@Override
public Message getEmployeesOfDepartment(String name)
{
        return null;
}
}
