package webshop.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import webshop.dto.ProductWithCategoryDto;
import webshop.mapper.ProductMapper;
import webshop.model.Product;
import webshop.repository.ProductRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    final ProductRepository productRepository;
    final ProductMapper productMapper;
    
    //1. megoldás, JsonIgnore kell hozzá
//    @GetMapping
//    public List<Product> listProducts() {
//        List<Product> allProducts = productRepository.findAll();
//        return allProducts;
//    }
    
    //2. megoldás, JsonIgnore nélkül, DTO-val
    @GetMapping
    public List<ProductWithCategoryDto> listProducts() {
        List<Product> allProducts = productRepository.findAll();
        return productMapper.toProductsWithCategoryDto(allProducts);
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }
}
