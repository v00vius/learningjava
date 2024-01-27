package service;

import dto.Errors;
import dto.Keys;
import dto.Registry;
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
public Registry newEmployee(Registry request)
{
        Registry response = new Properties ();
        Validator validator = new EmployeeValidator(request, response);

        if(0 != validator.check()) {
                response.setErrorCode(1);

                return response;
        }

        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        String jobPosition = request.get("jobPosition");

        Employee emp = employees.insert(firstName, lastName, jobPosition);

        response.set(Keys.key(Keys.INFO, 1),"Created: " + emp);
        response.set("id", Integer.toString(emp.getId()));
        response.setErrorCode(0);

        return response;
}

@Override
public Registry dismissEmployee(Registry registry)
{
        return null;
}
@Override
public Registry newDepartment(Registry registry)
{
        Registry response = new Properties ();
        Errors errors = new Errors(response);
        int errorCount = 0;

        String departmentName = registry.get("department");

        if(!departments.insert(departmentName))
                errors.setError(++errorCount, "Department '" + departmentName + "' already exists");

        if (errorCount == 0) {
                Department dep = departments.select(departmentName);

                response.set(Keys.key(Keys.INFO, 1),"Created: " + dep.getName());
                response.set("department", dep.getName());
                response.set("id", Integer.toString(dep.getId()));
        }

        response.setErrorCode(errorCount);

        return response;
}
@Override
public Registry deleteDepartment(Registry registry)
{
        return null;
}

@Override
public Registry setDepartmentForEmployee(Registry registry)
{
        Registry response = new Properties ();
        Errors errors = new Errors(response);
        int errorCount = 0;

        String departmentName = registry.get("department");
        int id = Integer.parseInt(registry.get("id"));

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
                response.set(Keys.key(Keys.INFO, 1),
                        "The employee ID=" + id + " has been added to the department '" +
                        department.getName() + "'"
                );
        }

        response.setErrorCode(errorCount);

        return response;
}
@Override
public Registry getEmployeesOfDepartment(Registry registry)
{
        Registry response = new Properties ();
        Errors errors = new Errors(response);
        int errorCount = 0;

        String departmentName = registry.get("department");
        Department department = departments.select(departmentName);

        if(department == null)
                errors.setError(++errorCount, "Department '" + departmentName + "' isn't known");

        if (errorCount == 0)
                fillResponse(department, response);

        response.setErrorCode(errorCount);

        return response;
}

private static void fillResponse(Department department, Registry response)
{
        List<Employee> employeesInDepartment = department.getEmployees();
        int count = 0;

        response.set("size", Integer.toString(employeesInDepartment.size()));
        response.set("department", department.getName());
        Iterator<Employee> cursor = employeesInDepartment.iterator();

        while (cursor.hasNext()) {
                Employee emp = cursor.next();

                response.set("emp/" + count + "/FirstName", emp.getFirstName());
                response.set("emp/" + count + "/LastName", emp.getLastName());
                response.set("emp/" + count + "/JobPosition", emp.getJobPosition());
                response.set("emp/" + count + "/Department", emp.getDepartment());

                ++count;
        }
}
}
