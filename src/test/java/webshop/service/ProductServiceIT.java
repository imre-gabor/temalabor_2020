package webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.ProductRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class ProductServiceIT {
    
    @Autowired
    SampleDataService sampleDataService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    ProductRepository productRepository;
    
    @Test
    void testDiscountProductsByName() throws Exception {
        
        //ARRANGE
        sampleDataService.initSampleData();
        
        //ACT
        productService.discountProductsByCategoryName("AAA", 10);
        
        //ASSERT
        assertThat(productRepository.findByName("prod1").get(0).getPrice()).isEqualTo(100);
        assertThat(productRepository.findByName("prod2").get(0).getPrice()).isEqualTo(90);
        assertThat(productRepository.findByName("prod3").get(0).getPrice()).isEqualTo(180);
    }
    
    @Test
    void testDiscountProductsByName2() throws Exception {
        
        //ARRANGE
        sampleDataService.initSampleData();
        
        //ACT
        productService.discountProductsByCategoryName("AAA", 10);
        
        //ASSERT
        assertThat(productRepository.findByName("prod1").get(0).getPrice()).isEqualTo(100);
        assertThat(productRepository.findByName("prod2").get(0).getPrice()).isEqualTo(90);
        assertThat(productRepository.findByName("prod3").get(0).getPrice()).isEqualTo(180);
    }

}
