package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "icons")
@NoArgsConstructor
@Getter
@Setter
public class Icon {
    @Id
    @Column(name = "icon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int icon_id;

    @Column(unique = true, nullable = false)
    private String name;

    public Icon(String name) {
        this.name = name;
    }
}
