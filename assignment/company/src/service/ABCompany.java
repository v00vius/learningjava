package service;

import dto.Error;
import dto.Keys;
import dto.Message;
import dto.Properties;
import entity.Department;
import entity.Employee;
import repo.DepartmentManager;
import repo.EmployeeManager;

import java.util.Iterator;
import java.util.List;

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
        Message response = new Properties ("newEmployee:response");
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
        Message response = new Properties ("newDepartment:response");
        Error errors = new Error(response);
        int errorCount = 0;

        String departmentName = message.getProperty("department");

        if(!departments.insert(departmentName))
                errors.setError(++errorCount, "Department '" + departmentName + "' already exists");

        if (errorCount == 0) {
                Department dep = departments.select(departmentName);

                response.setProperty(Keys.key(Keys.INFO, 1),"Created: " + dep.getName());
                response.setProperty("department", dep.getName());
                response.setProperty("id", Integer.toString(dep.getId()));
        }

        response.setErrorCode(errorCount);

        return response;
}
@Override
public Message deleteDepartment(Message message)
{
        return null;
}

@Override
public Message setDepartmentForEmployee(Message message)
{
        Message response = new Properties ("setDepartmentForEmployee:response");
        Error errors = new Error(response);
        int errorCount = 0;

        String departmentName = message.getProperty("department");
        int id = Integer.parseInt(message.getProperty("id"));

        Employee emp = employees.select(id);

        if(emp == null)
                errors.setError(++errorCount, "Employee id=" + id + " isn't known");

        Department department = departments.select(departmentName);

        if(department == null)
                errors.setError(++errorCount, "Department '" + departmentName + "' isn't known");

        if(errorCount == 0) {
                List<Employee> employeesInDepartment = department.getEmployees();

                employeesInDepartment.add(emp);
                emp.setDepartment(department.getName());
                response.setProperty(Keys.key(Keys.INFO, 1),
                        "The employee ID=" + id + " has been added to the department '" +
                        department.getName() + "'"
                );
        }

        response.setErrorCode(errorCount);

        return response;
}
@Override
public Message getEmployeesOfDepartment(Message message)
{
        Message response = new Properties ("getEmployeesOfDepartment:response");
        Error errors = new Error(response);
        int errorCount = 0;

        String departmentName = message.getProperty("department");
        Department department = departments.select(departmentName);

        if(department == null)
                errors.setError(++errorCount, "Department '" + departmentName + "' isn't known");

        if (errorCount == 0)
                fillResponse(department, response);

        response.setErrorCode(errorCount);

        return response;
}

private static void fillResponse(Department department, Message response)
{
        List<Employee> employeesInDepartment = department.getEmployees();
        int count = 0;

        response.setProperty("size", Integer.toString(employeesInDepartment.size()));
        response.setProperty("department", department.getName());
        Iterator<Employee> cursor = employeesInDepartment.iterator();

        while (cursor.hasNext()) {
                Employee emp = cursor.next();

                response.setProperty("emp/" + count + "/FirstName", emp.getFirstName());
                response.setProperty("emp/" + count + "/LastName", emp.getLastName());
                response.setProperty("emp/" + count + "/JobPosition", emp.getJobPosition());
                response.setProperty("emp/" + count + "/Department", emp.getDepartment());

                ++count;
        }
}
}
