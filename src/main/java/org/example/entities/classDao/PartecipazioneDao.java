package org.example.entities.classDao;

import org.example.entities.Evento;
import org.example.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class PartecipazioneDao {
    private final EntityManager em;

    public PartecipazioneDao(EntityManager em){
        this.em = em;
    }

    public void saveNewPartecipation(Partecipazione p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Partecipazione aggiunta a database");
    }
    public Partecipazione searchById(long id) {
        return em.find(Partecipazione.class,id);
    }
    public void removeById(long id){
        Partecipazione a = em.find(Partecipazione.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("Partecipazione rimossa con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("la Partecipazione con id " + id + " non esiste");
        }
    }
}
