package org.example.entities.classDao;

import org.example.entities.Evento;
import org.example.entities.Location;
import org.example.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class LocationDao {
    private final EntityManager em;

    public LocationDao(EntityManager em){
        this.em = em;
    }

    public void saveNewLoc(Location l) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(l);
        transaction.commit();
        System.out.println("Location aggiunta a database");
    }
    public Location searchById(long id) {
        return em.find(Location.class,id);
    }
    public void removeById(long id){
        Location a = em.find(Location.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("Location rimossa con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("la Location con id " + id + " non esiste");
        }
    }
}
