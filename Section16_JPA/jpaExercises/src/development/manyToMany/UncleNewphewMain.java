package development.manyToMany;

import db.DAO;
import model.manyToMany.Nephew;
import model.manyToMany.Uncle;

/**
 * The purpose of this class is to work with data that was a many-to-many relation.
 */
public class UncleNewphewMain {
    public static void main(String[] args) {
        Uncle u1 = new Uncle("Mary");
        Uncle u2 = new Uncle("Gabriel");
        Nephew n1 = new Nephew("Phillip");
        Nephew n2 = new Nephew("Maurice");
        DAO<Object> dao = new DAO<Object>();

        u1.getNephew().add(n1);
        u1.getNephew().add(n2);
        u2.getNephew().add(n1);
        u2.getNephew().add(n2);
        
        n1.getUncles().add(u1);
        n1.getUncles().add(u2);
        n2.getUncles().add(u1);
        n2.getUncles().add(u2);

        dao.atomicInsert(u1);
        dao.atomicInsert(u2);

    }
}
