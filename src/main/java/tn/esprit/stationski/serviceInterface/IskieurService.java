package tn.esprit.stationski.serviceInterface;

import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.util.List;

public interface IskieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur (Skieur skieur);
    Skieur retrieveSkieur ( Long numSkieur);
    void removeSkieur ( Long numSkieur);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    List<Skieur> retrieveSkieursBySAbonnementType(TypeAbonnement typeAbonnement);
}
