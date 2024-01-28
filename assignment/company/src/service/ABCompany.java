package service;

import dto.Errors;
import dto.Registry;
import dto.Properties;
import entity.Department;
import entity.Employee;
import entity.Entity;
import repo.DepartmentManager;
import repo.EmployeeManager;

import java.util.Iterator;
import java.util.List;
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
public String getName()
{
        return name;
}

public DepartmentManager getDepartments()
{
        return departments;
}

@Override
public Registry newEmployee(Registry request)
{
        Registry response = new Properties ();
        Errors errors = new Errors(response);
        Validator validator = new EmployeeValidator(request, errors);

        if(validator.check()) {
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
        int id = registry.getInt("/employee/id");
        Employee emp = employees.select(id);

        if(emp == null)
                errors.addError("Employee id=" + id + " isn't known");

        String departmentName = registry.get("/department/name");

        if(!departments.insert(registry.get(departmentName), emp))
                errors.addError("Department '" + departmentName + "' isn't known");

        if(errors.isEmpty()) {
                Department department = departments.select(departmentName);

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

        String departmentName = registry.get("/department/name");
        Department department = departments.select(departmentName);

        if(department == null)
                errors.addError("Department '" + departmentName + "' isn't known");

        if (errors.isEmpty())
                fillResponse(department, response);

        return response;
}
private static void fillResponse(Department department, Registry data)
{
        data.setTag("/employee");

        List<Employee> employees = department.getEmployees();
        Iterator<Employee> cursor = employees.iterator();
        int count = 0;

        while (cursor.hasNext())
                set(data, cursor.next(), count++);

        data.set("size", count);
}

static public void set(Registry data, Employee emp, int count)
{
        data.set("firstName", count, emp.getFirstName());
        data.set("lastName", count, emp.getLastName());
        data.set("jobPosition", count, emp.getJobPosition());
        data.set("department", count, emp.getDepartment());
}
@Override
public void load(Registry data)
{
        data.setTag("/employee");

        for (int i = 0, size = data.getInt("size"); i < size; ++i) {
                Employee emp = employees.insert(data.get("firstName", i),
                        data.get("lastName", i),
                        data.get("jobPosition", i)
                );

                String depName = data.get("department", i);

                departments.insert(depName);
                departments.insert(depName, emp);
        }

}

@Override
public String toString()
{
        return "ABCompany{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                ", employees=" + employees +
                '}';
}
}
