package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    ProductRepository productRepository;
    
    
    @Transactional
    public void discountProductsByCategoryName(String catName, int percent) {
        
        categoryRepository.findByName(catName).stream().forEach(c ->{
            c.getProducts().stream().forEach(prod -> {
                prod.setPrice((int)(prod.getPrice() / 100.0 *(100-percent)));
//                productRepository.save(prod); //fölösleges
            });
        });
    }
}
