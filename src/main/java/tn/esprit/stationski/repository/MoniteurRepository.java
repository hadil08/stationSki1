package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.entities.Piste;

public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
}
