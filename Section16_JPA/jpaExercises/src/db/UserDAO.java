package db;

import model.basic.User;

/**
 * Class that creates a proper DAO for the Users table.
 */
public class UserDAO extends DAO<User>{
    UserDAO(){
        super(User.class);
    }
}
