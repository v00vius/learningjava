package shoppinglist.repository;

import shoppinglist.dto.ProductDto;
import shoppinglist.entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepositoryArrayList implements ProductRepository{

    private List<Product> database;

    private Integer idCounter;

    public ProductRepositoryArrayList() {
        this.database = new ArrayList<>();
        this.idCounter = 0;
    }

    @Override
    public Integer addProduct(ProductDto productDto) {
        idCounter++;
        database.add(new Product(idCounter, productDto.getProductName(), productDto.getPrice(), productDto.getDescription()));
        return idCounter;
    }

    @Override
    public List<Product> findAll() {
        return database;
    }

    @Override
    public Product findById(Integer id) {

        for (Product currentProduct : database) {
            if (currentProduct.getId().equals(id)) {
                return currentProduct;
            }
        }

        return null;
    }

@Override
public Product delete(Integer id)
{
    Iterator<Product> cursor = database.iterator();

    while (cursor.hasNext()) {
        Product prod = cursor.next();

        if(prod.getId().equals(id)) {
            cursor.remove();

            return prod;
        }
    }

    return null;
}
}
