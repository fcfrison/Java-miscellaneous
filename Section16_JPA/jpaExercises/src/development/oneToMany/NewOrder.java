package development.oneToMany;

import db.DAO;
import model.basic.Product;
import model.oneToMany.Item;
import model.oneToMany.Order;

public class NewOrder {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<Object>();
        Product product = new Product("radio",100.00);
        Order order = new Order();
        Item item = new Item(2,order,product);
        dao.atomicInsert(item);
    }
}
