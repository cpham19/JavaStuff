package springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Product;
import springboot.model.dao.ProductDao;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductDao productDao;

    @GetMapping
    public List<Product> products(ModelMap models) {
        return productDao.getProducts();
    }
}