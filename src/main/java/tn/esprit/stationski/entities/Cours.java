package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private int niveau ;
    private float prix;
    private int creneau;

    @Enumerated(EnumType.STRING)
    private Support Support;

    @Enumerated(EnumType.STRING)
    private TypeCours TypeCours;

    //4/ 1->*
    @ToString.Exclude
    @OneToMany(mappedBy = "c")
     private Set<Inscription> inscriptions;

    //5/

}
