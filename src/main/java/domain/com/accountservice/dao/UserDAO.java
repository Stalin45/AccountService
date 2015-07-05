package domain.com.accountservice.dao;

/**
 * Created by iKapralo on 01.07.2015.
 */

import domain.com.accountservice.model.User;

public interface UserDAO extends GenericDAO<User> {

    User getById(Long id);
}
