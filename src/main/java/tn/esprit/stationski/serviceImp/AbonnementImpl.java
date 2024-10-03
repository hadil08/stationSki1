package tn.esprit.stationski.serviceImp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.repository.AbonnementRepoistory;
import tn.esprit.stationski.repository.SkieurRepository;
import tn.esprit.stationski.serviceInterface.IAbonnemntService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
@Slf4j
@AllArgsConstructor
@Service
public class AbonnementImpl implements IAbonnemntService {
    AbonnementRepoistory abonnementRepoistory;
    SkieurRepository skieurRepository;
    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbonnement) {
        return abonnementRepoistory.findByTypeSubOrderByStartDateAsc(typeAbonnement);
    }

   @Scheduled(cron = "*/30 * * * * *")
    @Override
    public void retrieveSubscriptions() {
       for (
               Abonnement abonnement : abonnementRepoistory.findDistinctOrderByEndDateAsc()) {
           Skieur aSkier = skieurRepository.findByAbonnement(abonnement);
           long differenceInDays = ChronoUnit.DAYS.between(LocalDate.now(), abonnement.getDateFin());
           if (differenceInDays < 7) {
               log.info(abonnement.getNomAbon().toString() + " | " + abonnement.getDateFin().toString()
                       + " | " + aSkier.getNomS() + " " + aSkier.getPrenomS());

           }
       }
   }
    @Scheduled(cron = "*/30 * * * * *")
    public void showMonthlyRecurringRevenue() {
        Float revenue = abonnementRepoistory.recurringRevenueByTypeSubEquals(TypeAbonnement.MENSUEL)
                + abonnementRepoistory.recurringRevenueByTypeSubEquals(TypeAbonnement.SEMESTERIEL)/6
                + abonnementRepoistory.recurringRevenueByTypeSubEquals(TypeAbonnement.ANNUEL)/12;
        log.info("Monthly Revenue = " + revenue);
    }
    }
