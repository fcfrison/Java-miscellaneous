package model.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @OneToOne(mappedBy = "seat") // 'client' is an attribute that makes possible
    private Client client;       // to access the 'client' related to a specific 
                                 // 'seat'. Considering that an one-to-one relationship
                                 // already exists inside the class Client, is necessary 
                                 // to set the parameter 'mappedBy'. 

    public Seat(){ // it's necessary to create a default constructor
    }

    public Seat(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
