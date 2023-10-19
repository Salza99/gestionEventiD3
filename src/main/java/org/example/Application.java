package org.example;

import org.example.entities.Concerto;
import org.example.entities.Location;
import org.example.entities.PartitaDiCalcio;
import org.example.entities.classDao.EventoDao;
import org.example.entities.classDao.LocationDao;
import org.example.entities.enumeratori.Genere;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory efm = JpaUtil.getEntityManagerFactory();
        EntityManager em = efm.createEntityManager();


        //inserisco delle location
        LocationDao dl = new LocationDao(em);
        /*Location lA = new Location("Arena", "Verona");
        Location lB = new Location("Teatro alla Scala","Milano");
        Location lC = new Location("Museo di Palazzo Poggi", "Bologna");
        dl.saveNewLoc(lA);
        dl.saveNewLoc(lB);
        dl.saveNewLoc(lC);*/
        Location foundlA = dl.searchById(1);
        Location foundlB = dl.searchById(2);
        Location foundlC = dl.searchById(3);
        //inserisco dei concerti
        EventoDao de = new EventoDao(em);
        /*Concerto ac = new Concerto("concerto", "concerto di Max Gazzè", LocalDate.of(2023,4,10), 500, foundlC, Genere.CLASSICO, true);
        Concerto bc = new Concerto("concerto", "concerto di Marrakesh", LocalDate.of(2024,6,15), 1500, foundlC, Genere.POP, false);
        Concerto cc = new Concerto("concerto", "concerto di AC/DC", LocalDate.of(2023,7,18), 1000, foundlC, Genere.ROCK, false);
        Concerto dc = new Concerto("concerto", "concerto di Linkin Park", LocalDate.of(2023,9,8), 400, foundlC, Genere.ROCK, true);
        de.saveNewEvent(ac);
        de.saveNewEvent(bc);
        de.saveNewEvent(cc);
        de.saveNewEvent(dc);*/
        de.getConcertiInStreaming(false).forEach(System.out::println);
        System.out.println("-----------------------------*------------------------------");
        de.getConcertiByGenre(Genere.CLASSICO).forEach(System.out::println);
        System.out.println("-----------------------------*------------------------------");
        /*PartitaDiCalcio acc = new PartitaDiCalcio("partita", "partita 1", LocalDate.of(2023, 4,12), 2000, foundlA, "ACF", "RM", "RM", 1, 2);
        PartitaDiCalcio bcc = new PartitaDiCalcio("partita", "partita 2", LocalDate.of(2023, 6,16), 3000, foundlB, "ATA", "CGL", "ATA", 2, 0);
        PartitaDiCalcio ccc = new PartitaDiCalcio("partita", "partita 3", LocalDate.of(2023, 5,7), 2500, foundlC, "MLN", "INT", "MLN", 3, 2);
        PartitaDiCalcio dcc = new PartitaDiCalcio("partita", "partita 4", LocalDate.of(2023, 11,1), 2350, foundlA, "SAS", "CV", "SAS", 3, 1);
        PartitaDiCalcio ecc = new PartitaDiCalcio("partita", "partita 5", LocalDate.of(2023, 8,23), 4000, foundlB, "GNA", "JVN", "JVN", 1, 4);
        de.saveNewEvent(acc);
        de.saveNewEvent(bcc);
        de.saveNewEvent(ccc);
        de.saveNewEvent(dcc);
        de.saveNewEvent(ecc);*/
        de.getPartiteVinteInCasa().forEach(System.out::println);
        System.out.println("-----------------------------*------------------------------");
        de.getPartiteVinteInTrasferta().forEach(System.out::println);
        em.close();
        efm.close();
    }
}
