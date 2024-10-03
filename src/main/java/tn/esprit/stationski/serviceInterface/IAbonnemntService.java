package tn.esprit.stationski.serviceInterface;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.util.Set;
public interface IAbonnemntService {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbonnement);
    void retrieveSubscriptions();
}
