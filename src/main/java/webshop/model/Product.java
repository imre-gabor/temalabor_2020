package webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    private int price;
    
    public Product() {
    }
    
    public Product(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }



    @ManyToOne
    private Category category;
}
