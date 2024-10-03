package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

@Repository
public interface AbonnementRepoistory extends JpaRepository<Abonnement,Long> {

    @Query("select a from Abonnement a where a.typeAbonnement =:typeAbonnement order by a.dateDebut")
    Set<Abonnement> findByTypeSubOrderByStartDateAsc(@Param("typeAbonnement") TypeAbonnement typeAbonnement);
    @Query("select distinct a from Abonnement a where a.dateFin <= CURRENT_TIME order by a.dateFin")
    List<Abonnement> findDistinctOrderByEndDateAsc();

    @Query("select (sum(a.prixAbon))/(count(a)) from Abonnement a where a.typeAbonnement = ?1")
    Float recurringRevenueByTypeSubEquals(TypeAbonnement typeAbonnement);

}

