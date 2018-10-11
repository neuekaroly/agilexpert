package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "menus")
@NoArgsConstructor
@Setter
@ToString
public class Menu {
    @Id
    @Column(name = "menu_id")
    private long menuId;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    public Menu(String menuName) {
        this.menuName = menuName;
    }
}
