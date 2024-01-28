package service;

import dto.Errors;
import dto.Properties;
import dto.Registry;
import entity.Department;
import entity.Employee;
import repo.DepartmentManager;
import repo.EmployeeManager;
import util.ConsoleIO;

import java.util.Collection;

public class ReportManager {
private ConsoleIO io;
private DepartmentManager departments;
private EmployeeManager employees;

public ReportManager(DepartmentManager departments, EmployeeManager employees)
{
        this.departments = departments;
        this.employees = employees;
        io = new ConsoleIO();
}
public Registry departments() {
        Registry data = new Properties();
        Collection<Department> list = departments.getDepartments();
        int count = 0;

        data.setTag("/department");

        for (Department dep : list)
                data.set("name", count++, dep.getName());

        data.set("size", count);

        return data;
}
public Registry employees() {
        Registry data = new Properties();
        Collection<Employee> list = employees.getEmployees();
        int count = 0;

        data.setTag("/employee");

        for (Employee emp : list)
                ABCompany.set(data, emp, count++);

        data.set("size", count);

        return  data;
}
public Registry findAny(Registry request) {
        Registry response = new Properties();
        Errors errors = new Errors(response);
        Validator validator = new PatternValidator(request, errors);

        response.set("/pattern", request.get("/pattern"));

        if(validator.check()) {

                String pattern = request.get("/pattern").toLowerCase();
                Collection<Employee> list = employees.getEmployees();
                int count = 0;

                response.setTag("/employee");

                for (Employee emp : list) {
                        String text = emp.getText().toLowerCase();

                        if (text.contains(pattern)) {
                                ABCompany.set(response, emp, count);
                                response.set("text", count, emp.getText());

                                ++count;
                        }
                }

                response.set("size", count);
        }

        return  response;
}
}
