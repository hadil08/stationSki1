package tn.esprit.stationski.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.repository.CoursRepository;
import tn.esprit.stationski.serviceInterface.IcoursService;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursServiceImp implements IcoursService {
    CoursRepository coursRepository ;
    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public void removeCours(Long numCours) {
        coursRepository.deleteById(numCours);
    }

    @Override
    public List<Cours> retrivetheInscriptionsOfCours(Long idCours) {
        return null;
    }
}
