import dao.DaoSession;
import model.Icon;
import model.Menu;
import model.User;

public class AgileExpert {
    public static void main(String[] args) {
        DaoSession<Menu> daoMenu = new DaoSession<Menu>(Menu.class);

        DaoSession<User> daoUser = new DaoSession<User>(User.class);

        for (int i = 0; i < 10; i++) {
            User user = new User("test" + i);
            user.getMainMenus().add(new Menu("test" + i));
            daoUser.persist(user);
        }

        for(User user : daoUser.findAll()) {
            System.out.println(user);
        }
    }

}
