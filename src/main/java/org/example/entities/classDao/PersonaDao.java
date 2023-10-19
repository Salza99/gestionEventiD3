package org.example.entities.classDao;

import org.example.entities.Evento;
import org.example.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em){
        this.em = em;
    }

    public void saveNewPerson(Persona p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Nuova perosna aggiunta a database");
    }
    public Persona searchById(long id) {
        return em.find(Persona.class,id);
    }
    public void removeById(long id){
        Persona a = em.find(Persona.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("Persona rimossa con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("la persona con id " + id + " non esiste");
        }
    }
}

