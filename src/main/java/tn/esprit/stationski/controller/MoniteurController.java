package tn.esprit.stationski.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.serviceInterface.ImoniteurService;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
@AllArgsConstructor
public class MoniteurController {
    ImoniteurService imoniteurService ;
    @GetMapping("/retrieveallMoniteur")
    public List<Moniteur> retrieveAllMoniteurs() {
        return imoniteurService.retrieveAllMoniteurs();
    }
    @PostMapping("/addMoniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return imoniteurService.addMoniteur(moniteur);
    }
    @PutMapping("/updateMoniteur/")
    public Moniteur updateMoniteur(@RequestBody  Moniteur moniteur) {
        return imoniteurService.updateMoniteur(moniteur);
    }
    @GetMapping("/retrieveMoniteur/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable  ("numMoniteur") Long numMoniteur) {
        return imoniteurService.retrieveMoniteur(numMoniteur);
    }
    @DeleteMapping("/deleteMoniteur/{numMoniteur}")
    public void removeMoniteur(@PathVariable ("numMoniteur") Long numMoniteur) {
        imoniteurService.removeMoniteur(numMoniteur);
    }

    @PostMapping ("/addInstructorAndAssignToCourse/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable("numCourse") Long numCourse) {
        return imoniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }
}
