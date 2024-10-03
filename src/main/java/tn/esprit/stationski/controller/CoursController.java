package tn.esprit.stationski.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.serviceInterface.IcoursService;

import java.util.List;
@Tag(name = "gestion courss")
@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class CoursController {
    IcoursService icoursService ;
    @GetMapping("/retrieveallCourses")
    public List<Cours> retrieveAllCourses() {
        return icoursService.retrieveAllCourses();
    }
    @PostMapping("/addCourses")
    public Cours addCours(Cours ccours) {
        return icoursService.addCours(ccours);
    }
    @PutMapping("/updateCourses")
    public Cours updateCours(Cours cours) {
        return icoursService.updateCours(cours);
    }
    @GetMapping("/retrieveCourses/{numCours}")
    public Cours retrieveCours(@PathVariable  ("numCours") Long numCours) {
        return icoursService.retrieveCours(numCours);
    }
    @DeleteMapping("/deleteCours/{numCours}")
    public void removeCours( @PathVariable ("numCours")Long numCours) {
        icoursService.removeCours(numCours);
    }
    @GetMapping("/retrieveallInscriptionByCourse/{numCours}")
    public List<Cours> retrivetheInscriptionsOfCours(@PathVariable  ("numCours") Long idCours) {
        return icoursService.retrivetheInscriptionsOfCours(idCours);
    }
}
