package repo;

import entity.Department;

import java.util.HashMap;
import java.util.Map;

public class DepartmentManager {
private Map<String, Department> departments;

public DepartmentManager()
{
        departments = new HashMap<>();
}
public boolean insert(Department dep)
{
        Department previousDep = departments.putIfAbsent(dep.getName(), dep);

        return previousDep == null;
}
public boolean delete(Department dep)
{
        return null != departments.remove(dep);
}

public Department select(String name)
{
        return departments.get(name);
}
}
