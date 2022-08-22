package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products") // Determining the name of the table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_name", length = 512, nullable = false) //setting the column 'name'
    private String name;

    @Column(name = "prod_price", precision = 11, scale = 2, nullable = true ) // for instance, 900546524.23
    private Double price;
    
    public Product() {//It's necessary for the JPA to work properly that the
    }                 // default constructor is defined.
    
    public Product(String name, Double price) {
        //this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
