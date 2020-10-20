package webshop.repository;

import java.util.List;

import webshop.model.Product;

public interface ProductRepository {

    public List<Product> findByName(String name);
    
    public void save(Product product);
    
    public void delete(Product product);
    
}
