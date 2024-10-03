package tn.esprit.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Piste implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private  Long numPiste ;
    private String nomPiste;
    private int longuer;
     private int pente ;

     @Enumerated(EnumType.STRING)
     private Couleur couleur;


    @ToString.Exclude
     @ManyToMany
     @JsonIgnore
    private Set<Skieur> skieurs;

    @ToString.Exclude
     @OneToOne
    private Abonnement abonnement;
}
