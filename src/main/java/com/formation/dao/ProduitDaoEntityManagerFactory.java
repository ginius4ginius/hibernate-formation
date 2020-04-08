package com.formation.dao;

import com.formation.entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProduitDaoEntityManagerFactory implements ProduitDao {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;


    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-formation-db");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }


    public void exit() {
        entityManager.close();
        entityManagerFactory.close();
    }


    public void create() {

        Produit produit = new Produit();
        produit.setNom("Bonbon à la fraise");
        produit.setPrix(1.5f);

        entityManager.persist(produit);
        entityManager.getTransaction().commit();

    }


    public void read() {

        long produitId= 2;
        Produit produit = entityManager.find(Produit.class, produitId);

        System.out.println("Nom: " + produit.getNom());
        System.out.println("Prix: " + produit.getPrix());

    }


    public void update() {

        Produit produit = new Produit();
        produit.setId(2);
        produit.setNom("Bonbon à la fraise des bois");
        produit.setPrix(1.5f);

        entityManager.merge(produit);
        entityManager.getTransaction().commit();

    }


    public void delete() {

        long produitId= 2;
        Produit reference = entityManager.getReference(Produit.class, produitId);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();

    }

    public void selectProduits() {

    }

    public void selectProduitsByCategorie() {

    }

    public void searchProduitByNom() {

    }


}
