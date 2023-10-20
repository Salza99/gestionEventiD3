package org.example.entities.classDao;

import org.example.entities.Concerto;
import org.example.entities.Evento;
import org.example.entities.PartitaDiCalcio;
import org.example.entities.enumeratori.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


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
    public List<Concerto> getConcertiInStreaming(boolean isStreaming){
        Query getAllStreamOrNoStreamQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :tf");
        getAllStreamOrNoStreamQuery.setParameter("tf", isStreaming);
        return getAllStreamOrNoStreamQuery.getResultList();
    }
    public List<Concerto> getConcertiByGenre(Genere g){
        Query findConcertiByGenre = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :g");
        findConcertiByGenre.setParameter("g", g);
        return findConcertiByGenre.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> getPartiteVinteInCasa = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa", PartitaDiCalcio.class);
        return getPartiteVinteInCasa.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> getPartiteVinteInTrasferta = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite", PartitaDiCalcio.class);
        return getPartiteVinteInTrasferta.getResultList();
    }
}
