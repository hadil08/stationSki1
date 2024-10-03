package tn.esprit.stationski.serviceInterface;

import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.Skieur;

import java.util.List;

public interface IpisteService {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Piste retrievePiste ( Long numPiste);
    void removePiste ( Long numPiste);
    List<Piste> retrieveBySkieur ( Long numSkieur);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

}
