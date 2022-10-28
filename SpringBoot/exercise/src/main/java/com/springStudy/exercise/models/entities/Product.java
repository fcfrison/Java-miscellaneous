package com.springStudy.exercise.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "prod_name", nullable = false)
    private String name;
    @ColumnDefault("0.0")
    @Column(name="price")
    @Min(0)
    private Double price;

    @ColumnDefault("0.0")
    @Column(name="discount")
    @Min(0)
    @Max(1) //Min and Max annotations allow for validation
    private Double discount;
    public Product() {
    }
    public Product(String name, Double price, Double discount) {
        this.name = name;
        this.discount = discount;
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
