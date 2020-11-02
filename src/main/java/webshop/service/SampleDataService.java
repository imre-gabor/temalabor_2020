package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@Service
public class SampleDataService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    
    @Transactional
    public void initSampleData() {
        
        Category savedCat = categoryRepository.save(new Category("AAA"));
        productRepository.save(new Product("prod1", 100));
        
        createProductWithCategory(savedCat, 100, "prod2");
        createProductWithCategory(savedCat, 200, "prod3");
    }

    private void createProductWithCategory(Category savedCat, int price, String name) {
        Product prod2 = new Product(name, price);
        prod2.setCategory(savedCat);
        savedCat.getProducts().add(prod2);
        productRepository.save(prod2);
    }

}
