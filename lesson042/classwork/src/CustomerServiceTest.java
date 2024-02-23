import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceTest {

    static List<Customer> customers = new ArrayList<>();
    static CustomerService service = new CustomerService(customers);

    @BeforeClass
    public static void initTests(){
        customers.add(new Customer(1,"John"));
        customers.add(new Customer(10,"James"));
        customers.add(new Customer(55,"Bill"));

    }

    @Test
    public void testGetCustomerById() {
        Customer expectedResult = new Customer(10,"James");
        Customer actualResult = service.getCustomerById(10);

        assertEquals(expectedResult, actualResult);
    }
}