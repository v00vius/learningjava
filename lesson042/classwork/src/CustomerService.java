import java.util.List;

public class CustomerService {
    /*
      Создайте класс CustomerService, который имеет метод getCustomerById(),
    который возвращает объект Customer по его идентификатору. Напишите тест,
    который проверяет, что метод getCustomerById() возвращает правильный
    объект Customer для заданного идентификатора.

     */

    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomerById(int id){
        for (Customer customer : customers){
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
