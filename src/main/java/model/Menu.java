package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Menu {
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int menuId;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "submenu_id")
    private List<SubMenu> subMenus;

    public Menu(String name) {
        this.name = name;
    }
}
