package dao;

import model.Icon;
import model.Menu;
import model.SubMenu;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoSessionFactorySingleton {

    private static SessionFactory sessionFactory;

    private DaoSessionFactorySingleton(){}

    public static synchronized SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
            return new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Menu.class)
                    .addAnnotatedClass(SubMenu.class)
                    .addAnnotatedClass(Icon.class)
                    .buildSessionFactory();
    }

}