package webshop.repository;

import java.util.List;

import webshop.model.Category;

public interface CategoryRepository {

    public List<Category> findByName(String name);
    
}
