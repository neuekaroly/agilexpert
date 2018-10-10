import dao.UserDao;
import model.User;

public class AgileExpert {
    public static void main(String[] args) {
        //create(new User("Test"));

        //read();

        /*SessionFactory sessionFactory = HibernateSingleton.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(new User("Test"));

        session.save(new User("Test2"));

        session.flush();

        transaction.commit();

        System.out.println(session.createQuery("FROM User").list().size()); //Terminal prints 2

        session.close();

        sessionFactory = HibernateSingleton.getSessionFactory();

        session = sessionFactory.openSession();

        read(session);*/

        UserDao userDao = new UserDao();

        userDao.openCurrentSessionWithTransaction();

        userDao.persist(new User("Test"));
        userDao.persist(new User("Test1"));

        System.out.println(userDao.findAll().get(0).toString());

        userDao.deleteAll();

        System.out.println(userDao.findAll().size());
    }

}
