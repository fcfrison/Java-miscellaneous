package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
    private static EntityManagerFactory emf; //Relating the 'emf' to the class
    private EntityManager em;
    private Class<E> class_; //For instance, User.class.

    static{ // static block for initialization of some variables
        try{
            emf = Persistence.createEntityManagerFactory("jpa-exercises");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public DAO(){
        this(null); //It's necessary to define the default constructor
    }

    public DAO(Class<E> class_){
        this.class_ = class_;
        this.em = emf.createEntityManager();
    }
    /**
     * This method opens the transaction with the db.
     * A transaction must be open when the operation involving the database
     * will cause some sort of modification on the db.
     * @return A DAO<E> instance.
     */
    public DAO<E> openTransaction(){
        this.em.getTransaction().begin();
        return this;
    }
    /**
     * This method commits the transaction with the db.
     * @return A DAO<E> instance.
     */
    public DAO<E> closeTransaction(){
        this.em.getTransaction().commit();
        return this;
    }

    /**
     * This method inserts data into db.
     * @param entity The object class
     * @return A DAO<E> instance
     */
    public DAO<E> insert(E entity){
        this.em.persist(entity);
        return this;
    }
    public DAO<E> atomicInsert(E entity){
        return this.openTransaction()
            .insert(entity).closeTransaction();
    }

    public List<E> queryAll(){
        return this.queryAll(10,5);
    }
    public List<E> queryAll(int limit, int offset){
        if(limit<offset){
            throw new IllegalArgumentException("The limit must be gt the offset.");
        }
        if(this.class_==null){
            throw new UnsupportedOperationException("The chosen class was not setted.");
        }
        String jpql = "SELECT e FROM " + class_.getName() + " e"; // it's necessary to declare the aliases
        TypedQuery<E> query = em.createQuery(jpql,class_);
        query.setMaxResults(limit); // set max ammount of row queried
        query.setFirstResult(offset); 
        return query.getResultList();//return the query via a list.
    }
    public void closeDao(){
        em.close();
    }
}
