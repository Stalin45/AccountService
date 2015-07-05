package domain.com.accountservice.dao.impl;

import domain.com.accountservice.dao.AccountDAO;
import domain.com.accountservice.model.Account;
import org.hibernate.Query;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @Author Илья
 * @Created 05.07.2015.
 */
@NamedQueries({
        @NamedQuery(
                name = "getByUserId",
                query = "from Account inner join User as user where user.id = :id"
        ),
        @NamedQuery(
                name = "getByPassport",
                query = "from Account inner join User as user where user.passport = :passport"
        )
})
public class AccountDAOImpl extends GenericDAOAbstract<Account> implements AccountDAO {

    private static final String HQL_GET_BY_USER_ID = "getByUserId";

    private static final String HQL_GET_BY_PASSPORT = "getByPassport";

    private static final String HQL_USER_ID_FIELD = "id";

    private static final String HQL_USER_PASSPORT_FIELD = "passport";

    public Account getById(Long id) {
        return (Account) session.get(Account.class, id);
    }

    public Account getByUserId(Long id) {
        Query query = session.getNamedQuery(HQL_GET_BY_USER_ID).setLong(HQL_USER_ID_FIELD, id);
        return (Account) query.uniqueResult();
    }

    public Account getByPassport(Integer passportNumber) {
        Query query = session.getNamedQuery(HQL_GET_BY_PASSPORT).setInteger(HQL_USER_PASSPORT_FIELD, passportNumber);
        return (Account) query.uniqueResult();
    }
}
