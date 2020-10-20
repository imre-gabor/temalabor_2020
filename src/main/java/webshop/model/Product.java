package webshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private long id;
    private String name;
    private int price;
    private Category category;
}
