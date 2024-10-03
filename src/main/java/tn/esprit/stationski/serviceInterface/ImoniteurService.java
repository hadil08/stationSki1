package tn.esprit.stationski.serviceInterface;

import tn.esprit.stationski.entities.Moniteur;

import java.util.List;

public interface ImoniteurService {


    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur ( Long numMoniteur);
    void removeMoniteur ( Long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
