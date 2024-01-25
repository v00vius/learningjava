package service;

import dto.message.Message;

public interface Company {
Message newEmployee(String firstName, String lastName, String jobPosition, String department);
Message dismissEmployee(Integer id);
Message newDepartment(String name);
Message deleteDepartment(String name);
Message setDepartmentForEmployee(Integer employeeId, String department);
Message getEmployeesOfDepartment(String name);
}
