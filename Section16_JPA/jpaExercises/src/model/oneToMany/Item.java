package model.oneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.basic.Product;
@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // one order has many items. Therefore, many items are related to one order.
    private Order order;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // one product is related to many items.Therefore, many items are related to one product.
    private Product product;

    public Item() {
    }

    public Item(int quantity, Order order, Product product) {
        this.setQuantity(quantity);
        this.setOrder(order);
        this.setProduct(product);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity>0){
            this.quantity = quantity;
        }else{
            throw new IllegalArgumentException("The quantity must be greater than zero.");
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.setPrice(product.getPrice());
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    

    
    
    
}
