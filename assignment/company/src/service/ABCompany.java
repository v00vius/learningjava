package service;

import dto.Keys;
import dto.Message;
import dto.Properties;
import entity.Employee;
import repo.DepartmentManager;
import repo.EmployeeManager;

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
public String getName()
{
        return name;
}

@Override
public Message newEmployee(Message request)
{
        Properties response = new Properties ("newEmployee:response");
        Validator validator = new EmployeeValidator(request, response);

        if(0 != validator.check()) {
                response.setErrorCode(1);

                return response;
        }

        String firstName = request.getProperty("firstName");
        String lastName = request.getProperty("lastName");
        String jobPosition = request.getProperty("jobPosition");

        Employee emp = employees.insert(firstName, lastName, jobPosition);

        response.setProperty(Keys.key(Keys.INFO, 1),"Created: " + emp);
        response.setProperty("id", Integer.toString(emp.getId()));
        response.setErrorCode(0);

        return response;
}

@Override
public Message dismissEmployee(Message message)
{
        return null;
}

@Override
public Message newDepartment(Message message)
{
        return null;
}

@Override
public Message deleteDepartment(Message message)
{
        return null;
}

@Override
public Message setDepartmentForEmployee(Message message)
{
        Properties response = new Properties ("setDepartmentForEmployee:response");
        String departmentName = message.getProperty("department");
        return null;
}

@Override
public Message getEmployeesOfDepartment(Message message)
{
        return null;
}
}
