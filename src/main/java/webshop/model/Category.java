package webshop.model;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    
    private long id;
    private String name;

    private Collection<Product> products;
}
