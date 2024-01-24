package shoppinglist.ui;

import shoppinglist.dto.ProductDto;
import shoppinglist.dto.ResponseForClientAddProduct;
import shoppinglist.service.ProductService;

import java.util.Scanner;

public class AddProductMenu implements MenuCommand{

    private final ProductService service;

    public AddProductMenu(ProductService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product name:");
        String name = scanner.nextLine();
        System.out.println("Please enter product description:");
        String description = scanner.nextLine();
        System.out.println("Please enter product price:");
        Double price = scanner.nextDouble();
        ProductDto productDto = new ProductDto(name, price, description);

        ResponseForClientAddProduct addResult = service.addNewProduct(productDto);
        System.out.println(addResult);

    }

    @Override
    public String getMenuName() {
        return "Add new product";
    }
}
