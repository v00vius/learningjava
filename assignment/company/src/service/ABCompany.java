package service;

import dto.Errors;
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
        Errors errors = new Errors(response);
        Validator validator = new EmployeeValidator(request, errors);

        validator.check();

        if(errors.isEmpty()) {
                request.setTag("/employee");

                Employee emp = employees.insert(request.get("firstName"),
                                        request.get("lastName"),
                                        request.get("jobPosition")
                );

                response.setTag("/employee");
                response.set("id", emp.getId());
                response.set("firstName", emp.getFirstName());
                response.set("lastName", emp.getLastName());
                response.set("jobPosition", emp.getJobPosition());
        }

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

        String departmentName = registry.get("/department/name");

        if(!departments.insert(departmentName))
                errors.addError("Department '" + departmentName + "' already exists");

        if (errors.isEmpty()) {
                Department dep = departments.select(departmentName);

                response.setTag("/department");
                response.set("id", dep.getId());
                response.set("name", dep.getName());
        }

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

        String departmentName = registry.get("/department/name");
        int id = registry.getInt("/employee/id");

        Employee emp = employees.select(id);

        if(emp == null)
                errors.addError("Employee id=" + id + " isn't known");

        Department department = departments.select(departmentName);

        if(department == null)
                errors.addError("Department '" + departmentName + "' isn't known");

        if(errors.isEmpty()) {
                List<Employee> employeesInDepartment = department.getEmployees();

                employeesInDepartment.add(emp);
                emp.setDepartment(department.getName());

                response.set("/department/name", department.getName());
                response.set("/employee/id", emp.getId());
        }

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
                errors.addError(++errorCount, "Department '" + departmentName + "' isn't known");

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
