package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "icons")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Icon {
    @Id
    @Column(name = "icon_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE)
    private int iconId;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "icons")
    private List<User> users = new LinkedList<User>();

    public Icon(String name) {
        this.name = name;
    }
}
