package entity;

import java.util.Objects;

public class Employee extends Entity {
private final String firstName;
private final String lastName;
private String jobPosition;
private String department;

public Employee(int id, String firstName, String lastName, String jobPosition)
{
        super(id);

        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
        this.department = "";
}

public String getFirstName()
{
        return firstName;
}

public String getLastName()
{
        return lastName;
}

public String getJobPosition()
{
        return jobPosition;
}

public String getDepartment()
{
        return department;
}

public void setDepartment(String department)
{
        this.department = department;
}

@Override
public boolean equals(Object o)
{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return getId() == employee.getId();
}

@Override
public int hashCode()
{
        return getId();
}
}
