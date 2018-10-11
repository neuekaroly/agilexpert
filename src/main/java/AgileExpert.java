import dao.DaoSession;
import dao.DaoSessionFactorySingleton;
import model.Icon;
import model.Menu;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AgileExpert {
    public static void main(String[] args) {
        DaoSession<Menu> daoMenu = new DaoSession<Menu>(Menu.class);

        DaoSession<User> daoUser = new DaoSession<User>(User.class);

        Menu menu = new Menu("test");
        menu.setMenuId(1);

        daoMenu.persist(menu);

        User user1 = new User("test1");
        User user2 = new User("test2");
        User user3 = new User("test3");

        user1.addMenu(menu);
        user2.addMenu(menu);
        user3.addMenu(menu);

        daoUser.persist(user1);
        daoUser.persist(user2);
        daoUser.persist(user3);

        menu = daoMenu.findAll().get(0);

        User user4 = new User("test4");

        user4.addMenu(menu);

        user4.setTheme(User.Theme.DARK);

        daoUser.persist(user4);

        System.out.println(daoMenu.findAll().size());

        System.out.println(daoUser.findAll().get(0));
        System.out.println(daoUser.findAll().get(1));
        System.out.println(daoUser.findAll().get(2));
        System.out.println(daoUser.findAll().get(3));

    }

}
