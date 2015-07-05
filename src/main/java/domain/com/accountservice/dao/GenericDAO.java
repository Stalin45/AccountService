package domain.com.accountservice.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Илья
 * @Created 05.07.2015.
 */
public interface GenericDAO<T extends Serializable> {

    void create(T object);

    void update(T object);

    void delete(T object);

    void deleteList(List<T> objectList);

    void beginTransaction();

    void commit();

    void rollback();
}
