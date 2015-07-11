package bl.com.accountservice.service.Impl;

import bl.com.accountservice.service.AccountService;
import domain.com.accountservice.dao.AccountDAO;
import domain.com.accountservice.dao.impl.AccountDAOImpl;
import domain.com.accountservice.exceptions.NotEnoughMoneyException;
import domain.com.accountservice.exceptions.UserWithoutAccountException;
import domain.com.accountservice.model.Account;

/**
 * @Author Илья
 * @Created 05.07.2015.
 */
public class AccountServiceImpl implements AccountService {

    public Long getAmount(Integer id) throws Exception {
        AccountDAO dao = new AccountDAOImpl();
        Account account;
        try {
            account = dao.getByUserId((long) id);
            if (account == null) {
                throw new UserWithoutAccountException("User with id = " +
                        id + " don't have an account");
            }
        } catch(Exception e) {
            //LOG
            throw e;
        }
        return  account.getBalance();
    }

    public Long addAmount(Integer id, Long value) throws Exception {
        AccountDAO dao = new AccountDAOImpl();
        Account account;
        try {
            dao.beginTransaction();
            account = dao.getByUserId((long) id);
            if (account == null) {
                throw new UserWithoutAccountException("User with id = " +
                        id + " don't have an account");
            }

            if (value < 0 && account.getBalance() - value < 0) {
                    throw new NotEnoughMoneyException("User with id = " +
                            id + " don't have enough money to complete transaction");
            }

            account.setBalance(value);
            dao.update(account);
            dao.commit();
        } catch(Exception e) {
            //LOG
            throw e;
        }
        return  account.getBalance();
    }
}
