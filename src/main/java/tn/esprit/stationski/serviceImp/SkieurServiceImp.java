package tn.esprit.stationski.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.*;
import tn.esprit.stationski.repository.CoursRepository;
import tn.esprit.stationski.repository.InscriptionRepository;
import tn.esprit.stationski.repository.SkieurRepository;
import tn.esprit.stationski.serviceInterface.IskieurService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurServiceImp implements IskieurService {
    SkieurRepository skieurRepository ;
    CoursRepository coursRepository ;
    InscriptionRepository inscriptionRepository ;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
       skieurRepository.save(skieur);

          for ( Inscription inscription : skieur.getInscriptions()){
              inscription.setSkieur(skieur);
              inscription.setC(cours);
              inscriptionRepository.save(inscription);
          }
          return skieur;
    }
    @Override
    public List<Skieur>  retrieveSkieursBySAbonnementType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbonnement(typeAbonnement);
    }


}
