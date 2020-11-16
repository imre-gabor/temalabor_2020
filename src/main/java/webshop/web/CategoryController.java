package webshop.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import webshop.model.Category;
import webshop.repository.CategoryRepository;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    final CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String listCategories(Map<String, Object> model) {
        List<Category> allCategories = categoryRepository.findAll();
        
        model.put("newCat", new Category());
        model.put("categories", allCategories);
        return "index";
    }
    
    @PostMapping("/categories")
    public String createCategory(Category category, Map<String, Object> model) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }
}
