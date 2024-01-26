package service;

import dto.Message;
import dto.Properties;
public interface Company {
String getName();
// massage: String firstName, String lastName, String jobPosition, String department
Message newEmployee(Message message);
// message: id
Message dismissEmployee(Message message);
// message: String name
Message newDepartment(Message message);
// message: String name
Message deleteDepartment(Message message);
// message: Integer employeeId, String department
Message setDepartmentForEmployee(Message message);
// message: String name
Message getEmployeesOfDepartment(Message message);
}
