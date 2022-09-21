package development.basic;

import db.DAO;
import model.oneToOne.Client;
import model.oneToOne.Seat;

public class insertOneToOne {
    public static void main(String[] args) {
        Seat seat = new Seat("2A");
        Client client = new Client("Ana",seat);
        DAO<Object> dao = new DAO<Object>(); // instead of creating two DAO objects, 
                                                     // it's better to create one that's more generic
        
        dao.openTransaction().insert(seat).insert(client).
                             closeTransaction().closeDao(); // given the structure of the classes, it's 
                                                            // necessary to insert the 'seat' first, and 
                                                            // then the 'client'.
    }
}
