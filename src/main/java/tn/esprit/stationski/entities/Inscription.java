package tn.esprit.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Inscription  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numInscription;
    private int numSemaine;
    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private Skieur skieur;

    //3/
    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private Cours c;
}
