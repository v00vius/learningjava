import dto.Registry;
import repo.DepartmentManager;
import repo.EmployeeManager;
import service.ABCompany;
import service.Company;
import service.RandomCompany;
import service.ReportManager;
import ui.*;

public class App extends Application {
private Company company;
private ReportManager reportManager;

@Override
void init()
{
        DepartmentManager departments = new DepartmentManager();
        EmployeeManager employees = new EmployeeManager();

        company = new ABCompany("ABC test", departments, employees);
        reportManager = new ReportManager(departments, employees);

        RandomCompany random = new RandomCompany();
        Registry data = random.nextCompany(100, 10);

        company.load(data);
}

@Override
void exec()
{
        Menu menu = new Menu("The Company app demo");

        menu.menuItem(new ItemTest());
        menu.menuItem(new ItemExit());
        menu.menuItem(new NewEmployee(company));
        menu.menuItem(new DismissEmployee(company));
        menu.menuItem(new DepartmentForEmployee(company));
        menu.menuItem(new EmployeesOfDepartment(company));
        menu.menuItem(new NewDepartment(company));
        menu.menuItem(new DeleteDepartment(company));
        menu.menuItem(new Departments(reportManager));
        menu.menuItem(new Employees(reportManager));
        menu.menuItem(new FindAny(reportManager));

        menu.menu();
}

public static void main(String[] args)
{
        Application companyDemo = new App();

        companyDemo.init();
        companyDemo.exec();
}

}
