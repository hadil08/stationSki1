package tn.esprit.stationski.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.serviceInterface.IpisteService;

import java.util.List;

@RestController
@RequestMapping("/piste")
@AllArgsConstructor
public class PisteController {
    IpisteService ipisteService ;
    //generate => delegate methods => injection de l'interface béch ma narja3ich lil coplage forte

@GetMapping("/retrieveallpiste")
    public List<Piste> retrieveAllPistes() {
        return ipisteService.retrieveAllPistes();
    }

    @PostMapping("/addpiste")
    public Piste addPiste(@RequestBody  Piste piste) {
        return ipisteService.addPiste(piste);
    }
@PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody  Piste piste) {
        return ipisteService.updatePiste(piste);
    }
    @GetMapping("/retrievePiste/{numPiste}")
    public Piste retrievePiste(@PathVariable ("numPiste") Long numPiste) {
        return ipisteService.retrievePiste(numPiste);
    }

    @DeleteMapping("/deletePiste/{numPiste}")
    public void removePiste(@PathVariable ("numPiste") Long numPiste) {
        ipisteService.removePiste(numPiste);
    }

    @GetMapping("/retrieveByskieur/{numskieur}")

    public List<Piste> retrieveBySkieur(@PathVariable ("numskieur")Long numSkieur) {
        return ipisteService.retrieveBySkieur(numSkieur);
    }

    @PutMapping ("/assignSkierToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable("numSkieur") Long numSkieur,
                                     @PathVariable("numPiste") Long numPiste) {
        return ipisteService.assignSkierToPiste(numSkieur, numPiste);
    }
}
