package development.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class mainUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("jpa-exercises"); // creates the em
        EntityManager em = emf.createEntityManager(); // object that manages the connection with a db
        User newUser = new User("Michel", "michl@email.com");
        em.getTransaction().begin(); // it's necessary to start a transaction, before insert data into the 'db'
        em.persist(newUser); //inserts data on the db
        em.getTransaction().commit();//it's necessary to commit the transaction for the data to persist
        em.close();
        emf.close();
    }
}
