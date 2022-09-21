package model.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "uncles")
public class Uncle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable( //it's possible to set the name of the join table and its fields.
        name = "nephews_uncles", //The name of the join table.
        joinColumns = @JoinColumn(name="uncle_id", referencedColumnName = "id"),//The name of the column related to the class Uncle
        inverseJoinColumns = @JoinColumn(name="nephew_id",referencedColumnName = "id")
    )
    private List<Nephew> nephew =  new ArrayList<Nephew>(20);

    public Uncle() {
    }

    public Uncle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nephew> getNephew() {
        return nephew;
    }

    public void setNephew(List<Nephew> nephew) {
        this.nephew = nephew;
    }

        

}
