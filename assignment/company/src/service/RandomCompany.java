package service;

import dto.Properties;
import dto.Registry;

import java.util.Random;

public class RandomCompany {
static private Random random = new Random(System.currentTimeMillis());
private Registry data;

public RandomCompany()
{
        data = new Properties();
}
public Registry nextCompany(int employeeCount, int departmentCount) {
        data.setTag("/employee");

        for (int i = 0; i < employeeCount; i++) {
                data.set("firstName", i, "FirstName" + random.nextInt(employeeCount));
                data.set("lastName", i, "LastName" + random.nextInt(employeeCount));
                data.set("jobPosition", i, "Position" + random.nextInt(employeeCount));
                data.set("department", i, "Dep" + random.nextInt(departmentCount));
        }

        data.set("size", employeeCount);

        return data;
}
}
