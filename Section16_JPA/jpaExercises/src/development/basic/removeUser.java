package development.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class removeUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("jpa-exercises");
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, 4L);
        // considering that we are changing the db, it's necessary to create a 
        // transaction
        em.getTransaction().begin();
        if(user != null){
            em.remove(user);
        }
        em.getTransaction().commit();
        emf.close();
        em.close();
    }
}
