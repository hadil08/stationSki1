package tn.esprit.stationski.serviceImp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repository.CoursRepository;
import tn.esprit.stationski.repository.MoniteurRepository;
import tn.esprit.stationski.serviceInterface.ImoniteurService;

import java.util.List;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements ImoniteurService {

    MoniteurRepository moniteurRepository ;
    CoursRepository coursRepository ;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return  moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }

    @Override
    @Transactional
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
       Cours cours = coursRepository.findById(numCourse).orElse(null);
    // moniteurRepository.save(moniteur); //ajout de moniteur dans la BD
       moniteur.getCours().add(cours);
       return moniteurRepository.save(moniteur);

    }

}
