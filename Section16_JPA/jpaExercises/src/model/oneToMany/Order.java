package model.oneToMany;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Date date;
    
    @OneToMany(mappedBy = "order", //once the relation many-to-one has been established,
                                    // if we intend to create a bidirectional relation between
                                   // attributes of two classes, it's necessary to inform
                                   // where the relation many-to-one was setted.
                fetch = FetchType.LAZY)  // By default, in a one-to-many relationship
                                          // the fetch parameter is setted to FetchType.LAZY.
                                          // But it's also possible to set fetch as FetchType.EAGER.  
                                   
    private List<Item> item;

    public Order() {
        this(new Date());//By default, use the present date.
    }
    
    public Order(Date date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    
    
}
