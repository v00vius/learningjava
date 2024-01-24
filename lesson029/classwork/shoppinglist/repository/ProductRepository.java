package shoppinglist.repository;

import shoppinglist.dto.ProductDto;
import shoppinglist.entity.Product;

import java.util.List;

public interface ProductRepository {

    Integer addProduct(ProductDto productDto);
    List<Product> findAll();
    Product findById(Integer id);
    Product delete(Integer id);
}
