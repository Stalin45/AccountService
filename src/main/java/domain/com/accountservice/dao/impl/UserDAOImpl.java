package domain.com.accountservice.dao.impl;

import domain.com.accountservice.dao.UserDAO;
import domain.com.accountservice.model.User;

/**
 * @Author Илья
 * @Created 05.07.2015.
 */
public class UserDAOImpl extends GenericDAOAbstract<User> implements UserDAO {

    public User getById(Long id) {
        return (User) session.get(User.class, id);
    }
}
