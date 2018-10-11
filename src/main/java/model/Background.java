package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "backgrounds")
@Setter
@Getter
@NoArgsConstructor
public class Background {
    @Id
    @GeneratedValue
    @Column(name = "background_id")
    private long backgroundId;

    @Column(name = "background_name")
    private String backgroundName;
}
