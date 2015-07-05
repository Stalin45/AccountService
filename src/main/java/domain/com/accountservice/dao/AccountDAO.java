package domain.com.accountservice.dao;

/**
 * Created by iKapralo on 01.07.2015.
 */

import domain.com.accountservice.model.Account;

public interface AccountDAO extends GenericDAO<Account> {

    Account getById(Long id);

    Account getByUserId(Long id);
}
