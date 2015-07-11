package domain.com.accountservice.dao.impl;

import java.io.Serializable;
import java.util.List;

import domain.com.accountservice.dao.GenericDAO;
import domain.com.accountservice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by iKapralo on 01.07.2015.
 */
public abstract class GenericDAOAbstract<T extends Serializable> implements GenericDAO<T> {

    protected Session session;

    protected Transaction transaction;

    {
        if (session == null) {
            session = HibernateUtil.getSessionFacroty().getCurrentSession();
        }
    }

    public void create(T object) {
        session.persist(object);
    }

    public void update(T object) {
        session.update(object);
    }

    public void delete(T object) {
        session.delete(object);
    }

    public void deleteList(List<T> objectList) {
        for (T object : objectList) {
            session.delete(object);
        }
    }

    public void beginTransaction() {
        if (session == null || !session.isConnected()) {
            session = HibernateUtil.getSessionFacroty().getCurrentSession();
        }

        transaction = session.beginTransaction();
    }

    public void commit() {
        if (session == null || transaction == null || !transaction.isActive()) {
            throw new RuntimeException("session or transaction is NULL");
        } else {
            transaction.commit();
        }
    }

    public void rollback() {
        if (session == null || transaction == null || !transaction.isActive()) {
            throw new RuntimeException("session or transaction is NULL");
        } else {
            transaction.rollback();
        }
    }
}
