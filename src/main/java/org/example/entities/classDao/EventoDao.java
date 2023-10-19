package org.example.entities.classDao;

import org.example.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class EventoDao {
    private final EntityManager em;

    public EventoDao(EntityManager em){
        this.em = em;
    }

    public void saveNewEvent(Evento e) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        System.out.println("evento aggiunto a database");
    }
    public Evento searchById(long id) {
        return em.find(Evento.class,id);
    }
    public void removeById(long id){
        Evento a = em.find(Evento.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("evento rimosso con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("l'evento con id " + id + " non esiste");
        }
    }
}
