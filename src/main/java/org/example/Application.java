package org.example;

import org.example.entities.classDao.EventoDao;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory efm = JpaUtil.getEntityManagerFactory();
        EntityManager em = efm.createEntityManager();



        em.close();
        efm.close();
    }
}
