package model.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nephews")
public class Nephew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToMany(mappedBy = "nephew",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Uncle> uncles = new ArrayList<Uncle>(20);  

    public Nephew() {
    }

    public Nephew(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Uncle> getUncles() {
        return uncles;
    }

    public void setUncles(List<Uncle> uncles) {
        this.uncles = uncles;
    }

        

}
