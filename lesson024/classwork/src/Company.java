import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Company {
    private Map<String, List<Employee>> departments;
    private Map<Employee, String> employees;
    private Map<Integer, Employee> byId;

    public Company() {
        departments = new HashMap<>();
        employees = new HashMap<>();
        byId = new HashMap<>();
    }

    Employee createEmployee(String name, String department) {
        Employee emp = new Employee(name, department);

        List<Employee>  list = departments.get(department);

        if(list == null) {
            list = new LinkedList<Employee>();
            departments.put(department, list);
        }

        list.add(emp);
        employees.put(emp, department);
        byId.put(emp.getId(), emp);

        return emp;
    }

    public Map<String, List<Employee>> getDepartments() {
        return departments;
    }
    public Map<Employee, String> getEmployees() {
        return employees;
    }
    public Map<Integer, Employee> getById() {
        return byId;
    }

    public static void main(String[] args) {
        Company company = new Company();

        company.createEmployee("Lucy", "Sales");
        company.createEmployee("James", "Sales");
        company.createEmployee("Graham", "Support");
        company.createEmployee("Ellis", "R&D");
        company.createEmployee("Scarlett", "R&D");
        company.createEmployee("Ella", "HR");

        System.out.println("+++ Departments ++++++++++++++++");
        System.out.println(company.getDepartments());

        System.out.println("+++ Employees +++++++++++++++++");
        System.out.println(company.getEmployees());

        System.out.println("+++ Employees IDs ++++++++++++++");
        System.out.println(company.getById());
    }
}
