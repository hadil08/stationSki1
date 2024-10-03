package tn.esprit.stationski.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.serviceInterface.IIinscriptionService;

import java.util.List;
import java.util.Set;

@Tag(name = "gestion inscription")
@RestController
@RequestMapping("/inscription")
@AllArgsConstructor
public class InscriptionController {
    IIinscriptionService iIinterfaceService ;
    @GetMapping("/retrieveAllInscription")
    public List<Inscription> retrieveAllInscription() {
        return iIinterfaceService.retrieveAllInscription();
    }

    @PostMapping("/addInscription")
    public Inscription addInscription(Inscription inscription) {
        return iIinterfaceService.addInscription(inscription);
    }


    @GetMapping("/findInscriptionBycourse/{numCours}")
    public Set<Inscription> findInscriptionBycourse(Long isCourse) {
        return iIinterfaceService.findInscriptionBycourse(isCourse);
    }
@PostMapping("/addInscriptionAndAssignToSkieur/{numski}")
    public Inscription addInscriptionAndAssignToSkieur(
            @RequestBody Inscription inscription,
            @PathVariable("numski") long numski) {
        return iIinterfaceService.addInscriptionAndAssignToSkieur(inscription, numski);
    }
    @PutMapping  ("/assignInscriptionToCourse/{numRegistration}/{numCourse}")
    public  Inscription assignInscriptionToCourse ( @PathVariable ("numRegistration") Long numRegistration,@PathVariable("numCourse") Long numCourse){
        return  iIinterfaceService.assignInscriptionToCourse(numRegistration,numCourse) ;
    }
}
