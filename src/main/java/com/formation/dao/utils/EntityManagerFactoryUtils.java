package com.formation.dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtils {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactoryUtils(){
        setup();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-formation-db");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }


    public void exit() {
        entityManager.close();
        entityManagerFactory.close();
    }



}
