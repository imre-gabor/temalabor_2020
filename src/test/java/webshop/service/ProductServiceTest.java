package webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;

//MOckito behúzása 2. megoldás
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @InjectMocks
    ProductService productService;
    
    @Mock
    CategoryRepository categoryRepository;
    
    //Mockito behúzása 1. megoldás
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
    
    @Test
    void testDiscountProductsByName() throws Exception {
        
        //ARRANGE
        Product product1 = new Product("abc", 100);
        Product product2 = new Product("def", 200);
        Category category = new Category("aaa");
        category.getProducts().add(product1);
        category.getProducts().add(product2);
        when(categoryRepository.findByName("aaa")).thenReturn(Arrays.asList(category));
        
        //ACT
        productService.discountProductsByCategoryName("aaa", 10);
        
        //ASSERT
        assertThat(product1.getPrice()).isEqualTo(90);
        assertThat(product2.getPrice()).isEqualTo(180);
    }

}
