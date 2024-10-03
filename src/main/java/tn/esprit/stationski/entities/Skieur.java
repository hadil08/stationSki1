package tn.esprit.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

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
public class Skieur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes;
    //@JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "skieur")
     private Set<Inscription> inscriptions;
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL) // lors de l'ajout de skieur l'abonnement va etre ajouter en m temps
    //@JsonIgnore
   private Abonnement abonnement;


}
