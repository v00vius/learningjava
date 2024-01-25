package repo;

import entity.Department;
import entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class DepartmentManager {
private Map<String, Department> departments;

public DepartmentManager()
{
        departments = new HashMap<>();
}
public boolean insert(String name)
{
        Department dep = departments.get(name);

        if(dep != null)
                return false;

        dep = new Department(Entity.newId(), name);
        departments.put(dep.getName(), dep);

        return true;
}
public Department delete(String name)
{
        return departments.remove(name);
}

public Department select(String name)
{
        return departments.get(name);
}
}
