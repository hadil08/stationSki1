package tn.esprit.stationski.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long nomAbon;
    @Temporal(TemporalType.DATE)

    private Date dateDebut;

    private LocalDate dateFin;
    private float prixAbon;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;



}
