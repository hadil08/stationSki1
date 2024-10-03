package tn.esprit.stationski.serviceInterface;

import tn.esprit.stationski.entities.Inscription;

import java.util.List;
import java.util.Set;

public interface IIinscriptionService {
    List<Inscription> retrieveAllInscription();
    Inscription addInscription(Inscription inscription );
    Inscription updateInscription (Inscription inscription);
    Inscription retrieveInscription ( Long numInscription);
    void removeInscription ( Long numInscription);

   Set<Inscription> findInscriptionBycourse (Long isCourse);
   Inscription addInscriptionAndAssignToSkieur(Inscription inscription , long numski);

    Inscription assignInscriptionToCourse(Long numRegistration, Long numCourse) ;
}
