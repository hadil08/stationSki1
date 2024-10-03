package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Piste;

import java.util.List;

@Repository
public interface PisteRepoistory  extends JpaRepository<Piste,Long> {

    List<Piste> findBySkieursNumSkieur( Long numSkieur);
    List<Piste> findBySkieursNomSLikeAndSkieursInscriptionsNumInscription(String nom , long numIns);
    List<Piste> findBySkieursNomSLike(String nomS);



}
