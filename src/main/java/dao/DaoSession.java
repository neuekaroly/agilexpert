package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class DaoSession <T> implements DaoInterface<T>{
    private Session currentSession;

    private Transaction currentTransaction;

    private Class<T> type;

    public DaoSession(Class<T> clazz) {
        this.type = clazz;
        openCurrentSessionWithTransaction();
    }

    public Session openCurrentSession() {
        currentSession = DaoSessionFactorySingleton.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = DaoSessionFactorySingleton.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSessionwithTransction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }


    public void persist(T entity) {
        getCurrentSession().save(entity);
        getCurrentTransaction().commit();
        currentTransaction = currentSession.beginTransaction();
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
        getCurrentTransaction().commit();
    }

    public T findById(int id) {
        T entitiy = getCurrentSession().get(type, id);
        return entitiy;
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
        getCurrentTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List<T> list = getCurrentSession().createQuery("from " + type.getSimpleName()).list();
        return list;
    }

    public void deleteAll() {
        List<T> list = findAll();
        for(T record : list) {
            delete(record);
        }
        getCurrentTransaction().commit();
    }
}
