import dao.HibernateUtil;
import dao.UserDao;
import model.Menu;
import model.SubMenu;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AgileExpert {
    public static void main(String[] args) {
        //create(new User("Test"));

        //read();

        /*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(new User("Test"));

        session.save(new User("Test2"));

        session.flush();

        transaction.commit();

        System.out.println(session.createQuery("FROM User").list().size()); //Terminal prints 2

        session.close();

        sessionFactory = HibernateUtil.getSessionFactory();

        session = sessionFactory.openSession();

        read(session);*/

        UserDao userDao = new UserDao();

        userDao.openCurrentSessionWithTransaction();

        userDao.persist(new User("Test"));
        userDao.persist(new User("Test1"));

        System.out.println(userDao.findAll().size());

        userDao.deleteAll();

        System.out.println(userDao.findAll().size());
    }
    
}
