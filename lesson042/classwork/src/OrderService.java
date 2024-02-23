import java.util.List;
import java.util.Objects;

public class OrderService {
static private int idSequence = 0;
private List<Order> orders;
public OrderService(List<Order> orders)
{
        this.orders = orders;
}
public int size()
{
        return orders.size();
}
public Order placeOrder(Order order)
{
        order.setId(++idSequence);
        orders.add(order);

        return order;
}
static public class Order {
private int id;
private double total;

        public Order()
        {
        }
        public Order(double total)
        {
                this.total = total;
        }
        public double getTotal()
        {
                return total;
        }
        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        @Override
        public boolean equals(Object o)
        {
                if (this == o) {
                        return true;
                }
                if (o == null || getClass() != o.getClass()) {
                        return false;
                }
                Order order = (Order) o;
                return id == order.id && Double.compare(total, order.total) == 0;
        }

        @Override
        public int hashCode()
        {
                return Objects.hash(id, total);
        }
}
}
