package tn.esprit.stationski.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.serviceInterface.IAbonnemntService;

import java.util.Set;
@Tag(name = "gestion abonnemnt")
@RestController
@RequestMapping("abonnement")
@AllArgsConstructor
public class AbonnementController {
    IAbonnemntService abonnemntService;
    @GetMapping("/all/{typeAbonnement}")
    public Set<Abonnement> getSubscriptionsByType(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement){
        return abonnemntService.getSubscriptionByType(typeAbonnement);
    }

}
