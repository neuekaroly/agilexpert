package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int userId;

    @Column(nullable = false, unique = true)
    private String userName;

    private String backGround;

    private String theme;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_menu", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "menu_id",
                    nullable = false, updatable = false) })
    private List<Menu> mainMenus = new LinkedList<Menu>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_icon",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private List<Icon> icons = new LinkedList<Icon>();

    public User(String userName) {
        this.userName = userName;
    }
}
