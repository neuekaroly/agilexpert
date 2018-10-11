package model;

import lombok.*;

import javax.persistence.*;

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
    private int iconId;

    @Column(unique = true, nullable = false)
    private String name;

   /* @ManyToMany(mappedBy = "icons")
    private List<User> users = new LinkedList<User>();*/

    public Icon(String name) {
        this.name = name;
    }
}
