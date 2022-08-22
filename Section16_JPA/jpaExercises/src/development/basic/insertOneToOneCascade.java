package development.basic;

import infra.DAO;
import model.oneToOne.Client;
import model.oneToOne.Seat;

public class insertOneToOneCascade {
    public static void main(String[] args) {
        Seat seat = new Seat("10F");
        Client client = new Client("Brad",seat);
        DAO<Client> dao = new DAO<Client>(Client.class);
        dao.atomicInsert(client);//Despite the fact that only a 'client' object
                                // is explicitly inserted, considering that the parameter 
                                //'cascade' was setted, the 'seat' object will also be inserted. 
    }
}
