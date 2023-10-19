package org.example;

import org.example.entities.Concerto;
import org.example.entities.Location;
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
        dl.saveNewLoc(lC);
        Location foundlA = dl.searchById(3);
        Location foundlB = dl.searchById(3);
        Location foundlC = dl.searchById(3);*/
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


        em.close();
        efm.close();
    }
}
