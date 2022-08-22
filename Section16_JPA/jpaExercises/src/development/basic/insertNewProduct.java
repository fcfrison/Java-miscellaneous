package development.basic;

import infra.DAO;
import model.basic.Product;

public class insertNewProduct {
    public static void main(String[] args) {
        Product produto = new Product("mouse",30.00);
        DAO<Product> dao_product = new DAO<Product>(Product.class);
        dao_product.openTransaction().insert(produto).closeTransaction().closeDao();

    }
}
