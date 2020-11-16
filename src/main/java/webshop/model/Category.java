package webshop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
//    @JsonIgnore
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        if (this.products == null)
            this.products = new ArrayList<>();

        return this.products;
    }
}
