package infra;
import model.basic.Product;

/**
 * Class that creates a proper DAO for the Product table.
 */
public class ProductDAO extends DAO<Product>{
    ProductDAO(){
        super(Product.class);
    }
}
