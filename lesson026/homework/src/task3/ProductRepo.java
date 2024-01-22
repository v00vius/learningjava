package task3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProductRepo {
private Set<Product> products;

public ProductRepo()
{
        products = new HashSet<>();
}
public Product insert(String name, double price)
{
        Product prod = new Product(name, price);
        boolean rc = products.add(prod);

        return rc ? prod : null;
}
public Product delete(String name)
{
        Product prod = select(name);

        if(prod != null)
                products.remove(prod);

        return prod;
}
public Product select(String name)
{
        Iterator<Product> it = products.iterator();

        while(it.hasNext()) {
                Product prod = it.next();

                if(prod.getName().equals(name))
                        return prod;
        }

        return null;
}

@Override
public String toString()
{
        return "ProductRepo{" +
               "products=" + products +
               '}';
}
}
