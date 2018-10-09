package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "submenus")
@Getter
@Setter
public class SubMenu {
    @Id
    @Column(name = "submenu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;
}
