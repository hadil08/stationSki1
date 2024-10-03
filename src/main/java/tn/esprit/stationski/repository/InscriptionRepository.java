package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Inscription;

import java.util.List;
import java.util.Set;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    //Récupérer la liste des inscriptions d'un cours
    Set<Inscription> findByCNum(Long idCours);

}
