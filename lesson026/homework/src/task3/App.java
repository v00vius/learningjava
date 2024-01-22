package task3;

public class App {
public static void main(String[] args)
{
        ProductRepo repo = new ProductRepo();
        String[] prods = new String[] {
                "carrot", "garlic", "onion", "potato"
        };

        double[] price = new double[] {
                1., 2., 3., 4.
        };

        for (int i = 0; i < prods.length; i++) {
                repo.insert(prods[i], price[i]);
        }

        System.out.println(repo);

        Product prod = repo.select("garlic");
        System.out.println("Found: " + prod);

        prod = repo.delete("onion");
        System.out.println("To delete:" + prod);
        System.out.println(repo);
}
}
