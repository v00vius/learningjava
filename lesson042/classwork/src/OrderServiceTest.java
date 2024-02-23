import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
List<OrderService.Order> orders;
OrderService service;

@BeforeEach
void setUp()
{
        orders = new ArrayList<>();
        service = new OrderService(orders);
}
@Test
void placeOrder()
{
        var expected = new OrderService.Order(20.);
        var got = service.placeOrder(expected);

        assertEquals(expected, got);
        assertTrue(got.getId() == 1);
        assertTrue(service.size() == 1);
}
@Test
void placeOrder1()
{
        var expected = new OrderService.Order(30.);
        var got = service.placeOrder(expected);

        assertEquals(expected, got);
        assertTrue(got.getId() == 2 );
        assertTrue(service.size() == 2);
}
}