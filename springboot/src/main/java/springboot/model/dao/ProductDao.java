package springboot.model.dao;

import java.util.List;

import springboot.model.Product;

public interface ProductDao {

    Product getProduct(Integer id);

    List<Product> getProducts();

    Product saveProduct(Product product);
}