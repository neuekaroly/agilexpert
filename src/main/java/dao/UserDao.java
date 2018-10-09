package dao;

import lombok.Getter;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Getter
public class UserDao implements DaoInterface<User>{
    private Session currentSession;

    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSeseionwithTransction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    public User findById(int id) {
        User user = getCurrentSession().get(User.class, id);
        return user;
    }

    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        List<User> users = getCurrentSession().createQuery("from User").list();
        return users;
    }

    public void deleteAll() {
        List<User> users = findAll();
        for(User user : users) {
            delete(user);
        }
    }
}


