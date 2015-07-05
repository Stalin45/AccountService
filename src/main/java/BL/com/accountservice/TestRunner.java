package BL.com.accountservice;

import domain.com.accountservice.dao.UserDAO;
import domain.com.accountservice.dao.impl.UserDAOImpl;
import domain.com.accountservice.model.User;

/**
 * @Author Илья
 * @Created 04.07.2015.
 */
public class TestRunner {

    public static void main(String[] args) {

        User user = new User();
        user.setId(10L);
        user.setFirstName("lol");
        user.setLastName("pak");
        user.setPassportNumber(123);

        UserDAO userDAO = new UserDAOImpl();
        userDAO.beginTransaction();
        userDAO.create(user);
        userDAO.commit();
    }
}
