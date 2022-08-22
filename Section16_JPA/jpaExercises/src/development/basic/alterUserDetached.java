package development.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

// It's possible to work with objects that are not in a management state
public class alterUserDetached {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                        createEntityManagerFactory("jpa-exercises");
        EntityManager em = emf.createEntityManager();
        //Considering the goal here is to update data, it's necessary to start a transaction.
        em.getTransaction().begin();
        User user = em.find(User.class, 1L);

        // here is the point where the object enters the unmanaged state  
        em.detach(user);
        
        System.out.println(user.getEmail());// once we have the result, we can 
                                            // process it via the User class. 
        //here, we update the user e-mail and name
        user.setEmail("johann@email.com");
        user.setName("Johann");
        
        //considering that we're in an unmanaged state, it's necessary to 
        //explicitly merge the object. 
        em.merge(user); //updating data
        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
