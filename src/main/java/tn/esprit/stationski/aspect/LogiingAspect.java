package tn.esprit.stationski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogiingAspect {

    //.add* : les methodes qui commence par add
    @After("execution(* tn.esprit.stationski.serviceImp.*.get*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name= joinPoint.getSignature().getName();
        log.info("Ajout avec succées:" +name);
    }

    @Before("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


    @AfterThrowing("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryAfterTH(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryAfterRT(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


}
