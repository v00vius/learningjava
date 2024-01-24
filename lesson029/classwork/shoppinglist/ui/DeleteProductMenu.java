package shoppinglist.ui;

import shoppinglist.dto.ProductDto;
import shoppinglist.dto.ResponseForClientAddProduct;
import shoppinglist.dto.ResponseForClientDeleteById;
import shoppinglist.service.ProductService;

import java.util.Scanner;

public class DeleteProductMenu implements MenuCommand{

    private final ProductService service;

    public DeleteProductMenu(ProductService service) {
        this.service = service;
    }

    @Override
    public void executeCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product ID to delete:");

        int id = scanner.nextInt();

        ResponseForClientDeleteById addResult = service.deleteById(id);
        System.out.println(addResult);
    }

    @Override
    public String getMenuName() {
        return "Delete a product by its ID";
    }
}
