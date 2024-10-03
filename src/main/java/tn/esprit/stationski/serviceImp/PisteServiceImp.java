package tn.esprit.stationski.serviceImp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.repository.PisteRepoistory;
import tn.esprit.stationski.repository.SkieurRepository;
import tn.esprit.stationski.serviceInterface.IpisteService;

import java.util.List;
@Service
@AllArgsConstructor
public class PisteServiceImp implements IpisteService {

    PisteRepoistory pisteRepoistory ;
    SkieurRepository skieurRepository ;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepoistory.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepoistory.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepoistory.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepoistory.findById(numPiste).orElse(null);
    }

    @Override
    public void removePiste(Long numPiste) {
          pisteRepoistory.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveBySkieur(Long numSkieur) {
       return pisteRepoistory.findBySkieursNumSkieur(numSkieur);
    }

    @Override
    @Transactional
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur =skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepoistory.findById(numPiste).orElse(null);
        piste.getSkieurs().add(skieur);
         // pisteRepoistory.save(piste);
          return skieur;
    }
}
