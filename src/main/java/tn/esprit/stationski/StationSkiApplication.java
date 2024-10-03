package tn.esprit.stationski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@scheduled nhotha f methode sans parametre w f scheduled nhotou parametre()

@EnableAspectJAutoProxy

@SpringBootApplication
public class StationSkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationSkiApplication.class, args);
    }

}
