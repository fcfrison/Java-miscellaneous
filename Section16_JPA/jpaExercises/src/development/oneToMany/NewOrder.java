package development.oneToMany;

import infra.DAO;
import model.basic.Product;
import model.oneToMany.Item;
import model.oneToMany.Order;

public class NewOrder {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<Object>();
        Product product = new Product("tv",1000.00);
        Order order = new Order();
        Item item = new Item(1,order,product);
        dao.atomicInsert(item);
    }
}
