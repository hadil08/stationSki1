package tn.esprit.stationski.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.serviceInterface.IskieurService;

import java.util.List;

@RestController
@RequestMapping("/skieur")
@AllArgsConstructor
public class SkieurController {
    IskieurService iskieurService ;
@GetMapping("/retrieveAllSkieur")
    @Operation(description = "cette methode permet d'afficher tout les skieurs")
    public List<Skieur> retrieveAllSkieurs() {
        return iskieurService.retrieveAllSkieurs();
    }
    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return iskieurService.addSkieur(skieur);
    }
    @PutMapping("/updateSkieur/{numSkieur}")
    public Skieur updateSkieur(  @RequestBody Skieur skieur) {
        return iskieurService.updateSkieur(skieur);
    }
    @GetMapping("/retrieveSkieur/{numSkieur}")

    public Skieur retrieveSkieur(@PathVariable ("numSkieur") Long numSkieur) {
        return iskieurService.retrieveSkieur(numSkieur);
    }
    @DeleteMapping("/deleteSkieur/{numSkieur}")
    public void removeSkieur(@PathVariable ("numSkieur") Long numSkieur) {
        iskieurService.removeSkieur(numSkieur);
    }

    @PostMapping ("/addSkierAndAssignToCourse/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable ("numCourse") Long numCourse) {
        return iskieurService.addSkierAndAssignToCourse(skieur, numCourse);
    }

    @GetMapping("/retrieveSkieursByAbonnementType/{typeAbonnement}")
    public List<Skieur> retrieveSkieursBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement) {
        return iskieurService.retrieveSkieursBySAbonnementType(typeAbonnement);
    }

}
