package tn.esprit.stationski.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.repository.CoursRepository;
import tn.esprit.stationski.repository.InscriptionRepository;
import tn.esprit.stationski.repository.SkieurRepository;
import tn.esprit.stationski.serviceInterface.IIinscriptionService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class InscriptionImp implements IIinscriptionService {
    InscriptionRepository inscriptionRepository ;
    SkieurRepository skieurRepository ;
    CoursRepository coursRepository ;
    @Override
    public List<Inscription> retrieveAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return  inscriptionRepository.findById(numInscription).orElse(null);


}

    @Override
    public void removeInscription(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);
    }

    @Override
    public Set<Inscription> findInscriptionBycourse(Long isCourse) {
        return inscriptionRepository.findByCNum(isCourse);
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription,
                                                       long numski) {
        Skieur skieur  = skieurRepository.findById(numski).orElse(null);
        inscription.setSkieur(skieur);
        return  inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignInscriptionToCourse(Long numRegistration, Long numCourse) {
      Cours cours = coursRepository.findById(numCourse).orElse(null);
      Inscription inscription = inscriptionRepository.findById(numRegistration).orElse(null) ;
      inscription.setC(cours);
      return  inscriptionRepository.save(inscription);




    }
}
