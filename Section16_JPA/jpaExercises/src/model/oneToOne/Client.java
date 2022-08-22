package model.oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // Creating a one-to-one relationship.
                        // The parameter 'cascade' makes possible to alter the Seat table without
                        // explicitly ask the script to do so. 
    @JoinColumn(name="seat_id", unique = true) // 'seat' it's a foreignkey
    private Seat seat;

    public Client() {

    }

    public Client(String name, Seat seat) {
        this.name = name;
        this.seat = seat;
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


    public Seat getSeat() {
        return seat;
    }


    public void setSeat(Seat seat) {
        this.seat = seat;
    }
     

}
