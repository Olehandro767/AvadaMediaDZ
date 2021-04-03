package ua.AvadaMedia.admin.ModelDAO;

import org.hibernate.Session;

import java.util.List;

public interface IDelegateModelDAOHibernate<T> {

    Session getSessionAndBeginTransaction();
    void commitAndCloseSession();
    void add(T... t);
    void add(T t);
    List<T> getListOfEntity(String hql);

}
