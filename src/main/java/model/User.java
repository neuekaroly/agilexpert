package model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_menu",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")})
    private List<Menu> menus = new LinkedList<Menu>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_icon",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "icon_id")})
    private List<Icon> icons = new LinkedList<Icon>();

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Theme theme;

    private String backGround;

    public User(String userName) {
        this.userName = userName;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public enum Theme {DARK, WHITE, MATERIAL, FLAT}
}
