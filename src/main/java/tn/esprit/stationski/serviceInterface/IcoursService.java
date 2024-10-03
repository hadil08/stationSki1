package tn.esprit.stationski.serviceInterface;

import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Piste;

import java.util.List;

public interface IcoursService {

    List<Cours> retrieveAllCourses();
    Cours addCours(Cours ccours );
    Cours updateCours (Cours cours);
    Cours retrieveCours ( Long numCours);
    void removeCours ( Long numCours);
      List<Cours> retrivetheInscriptionsOfCours (Long idCours) ;


}
