package ua.AvadaMedia.admin.ModelDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectModelDAOHibernate<T> implements IDelegateModelDAOHibernate<T>{

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public Session getSessionAndBeginTransaction() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public void commitAndCloseSession() {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(T... t_s) {
        getSessionAndBeginTransaction();
        for (T t :t_s)
            session.save(t);
        commitAndCloseSession();
    }

    @Override
    public void add(T t) {
        getSessionAndBeginTransaction();
        session.save(t);
        commitAndCloseSession();
    }

    @Override
    public List<T> getListOfEntity(String hql) {
        List<T> list = getSessionAndBeginTransaction().createQuery(hql).list();
        commitAndCloseSession();
        return list;
    }

}
