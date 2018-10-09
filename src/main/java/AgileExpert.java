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

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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

        read(session);
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Menu.class)
                .addAnnotatedClass(SubMenu.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Menu.class);
        configuration.addAnnotatedClass(SubMenu.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public static Integer create(User user) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + user.toString());
        return user.getId();
    }

    public static List<User> read(Session session) {
        System.out.println(session.createQuery("FROM User").list().size());

        return null;
    }

}
