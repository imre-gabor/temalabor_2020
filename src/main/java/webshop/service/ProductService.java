package webshop.service;

import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

public class ProductService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    
    public void discountProductsByCategoryName(String catName, int percent) {
        
        categoryRepository.findByName(catName).stream().forEach(c ->{
            c.getProducts().stream().forEach(prod -> {
                prod.setPrice((int)(prod.getPrice() / 100.0 *(100-percent)));
//                productRepository.save(prod); //fölösleges
            });
        });
    }
}
