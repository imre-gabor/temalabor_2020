package webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import webshop.dto.CategoryNoProductsDto;
import webshop.dto.ProductWithCategoryDto;
import webshop.model.Category;
import webshop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    CategoryNoProductsDto toCategoryNoProductsDto(Category category);
    
    List<ProductWithCategoryDto> toProductsWithCategoryDto(List<Product> product);
}
