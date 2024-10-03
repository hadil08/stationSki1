package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationski.entities.Cours;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long>  {


    //Récupérer le cours d'une inscription

    Cours findByInscriptionsNumInscription(Long idIns);




}
