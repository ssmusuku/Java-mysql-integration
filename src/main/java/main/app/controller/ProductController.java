package main.app.controller;

import main.app.entity.Product;
import main.app.model.ProductInformation;
import main.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    ProductRepository product;
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
    @GetMapping("/getAllProducts")
    public List<ProductInformation> getAllproduct(){
        List<Product> productInDB = product.findAll();
        List<ProductInformation> productWithNameAndPrice = new ArrayList<>();
        for(Product product:  productInDB){
            ProductInformation productInfo = new ProductInformation();
            productInfo.setProductName(product.getProductName());
            productInfo.setPrice(product.getPrice());
            productWithNameAndPrice.add(productInfo);
        }
        return productWithNameAndPrice;

    }
}
