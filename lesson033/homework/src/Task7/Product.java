package Task7;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Product {
private String name;
private String category;
private double price;
private int available;

public Product(String name, String category, double price, int available)
{
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
}

public String getName()
{
        return name;
}

public String getCategory()
{
        return category;
}

public double getPrice()
{
        return price;
}

public int getAvailable()
{
        return available;
}

static public class ProductFactory implements IntFunction<Product> {
        private int numCategories;
        private double priceRange;

        public ProductFactory(int numCategories, double priceRange)
        {
                this.numCategories = numCategories;
                this.priceRange = priceRange;
        }

        static private Random random = new Random(System.currentTimeMillis());

        @Override
        public Product apply(int value)
        {
                String aName = "Name" + value;
                String aCategory = "Cat" + random.nextInt(0, numCategories);
                double aPrice = random.nextDouble(.1, priceRange);

                return new Product(aName, aCategory, aPrice, random.nextInt(100));
        }
}
@Override
public String toString()
{
        return "\nProduct{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
}

public static void main(String[] args)
{
        ProductFactory productFactory = new ProductFactory(10, 200.);
        List<Product> products = IntStream.range(1, 100)
                .mapToObj(productFactory)
                .toList();

        System.out.println(products);

        List<Product> prod1 = products.stream()
                .filter(p -> p.getAvailable() > 90)
                .toList();

        System.out.println("#--------------------------------");
        System.out.println(prod1);

        Map<String, Double> prod2 = products.stream()
                .filter(p -> p.getAvailable() > 95)
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));

        System.out.println("#--------------------------------");
        System.out.println(prod2);

        List<Map.Entry<String, Double >> listByPrice  = prod2.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .toList();

        System.out.println("#--------------------------------");
        System.out.println(listByPrice);
}
}
