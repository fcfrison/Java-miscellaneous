package development.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

/**
 * The code below shows a way to update data from the User table.
 */
public class alterUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                        createEntityManagerFactory("jpa-exercises");
        EntityManager em = emf.createEntityManager();
        //Considering the goal here is to update data, it's necessary to start a transaction.
        em.getTransaction().begin();
        User user = em.find(User.class, 1L);
        System.out.println(user.getEmail());// once we have the result, we can 
                                            // process it via the User class. 
        //here, we update the user e-mail and name
        user.setEmail("johann@email.com");
        user.setName("Johann");
        em.merge(user); //updating data
        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
