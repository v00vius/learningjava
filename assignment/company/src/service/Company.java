package service;

import dto.Registry;

public interface Company {
String getName();
// massage: String firstName, String lastName, String jobPosition, String department
Registry newEmployee(Registry registry);
// message: id
Registry dismissEmployee(Registry registry);
// message: String name
Registry newDepartment(Registry registry);
// message: String name
Registry deleteDepartment(Registry registry);
// message: Integer employeeId, String department
Registry setDepartmentForEmployee(Registry registry);
// message: String name
Registry getEmployeesOfDepartment(Registry registry);
void load(Registry data);
}
