package webshop.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import webshop.model.Category;

@Getter
@Setter
public class ProductWithCategoryDto {
    private long id;
    private String name;
    private int price;
    private CategoryNoProductsDto category;
}
