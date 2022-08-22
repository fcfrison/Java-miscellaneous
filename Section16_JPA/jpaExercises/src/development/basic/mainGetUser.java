package development.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class mainGetUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("jpa-exercises");
            //the persisnteceUnitName must match a persistence-unit from the persistence.xml. 
        EntityManager em = emf.createEntityManager();
        try{ 
        // there's no need to open a transaction, if the goal is to get data from database
        User user = em.find(User.class, 10L);
        System.out.println("===> " + user.getName());
    }catch(NullPointerException e){
        System.out.println(e.toString());
    }finally{
        emf.close();
        em.close();
    }
    }
}
