package com.formation.dao;

import com.formation.dao.utils.EntityManagerFactoryUtils;
import com.formation.entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProduitDaoEntityManagerFactory implements ProduitDao {

    private EntityManagerFactoryUtils entityManagerFactoryUtils = new EntityManagerFactoryUtils();


    public void create() {

        Produit produit = new Produit();
        produit.setNom("Bonbon à la fraise");
        produit.setPrix(1.5f);

        entityManagerFactoryUtils.getEntityManager().persist(produit);
        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }


    public void read() {

        long produitId= 2;
        Produit produit = entityManagerFactoryUtils.getEntityManager().find(Produit.class, produitId);

        System.out.println("Nom: " + produit.getNom());
        System.out.println("Prix: " + produit.getPrix());

    }


    public void update() {

        Produit produit = new Produit();
        produit.setId(2);
        produit.setNom("Bonbon à la fraise des bois");
        produit.setPrix(1.5f);

        entityManagerFactoryUtils.getEntityManager().merge(produit);
        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }


    public void delete() {

        long produitId= 2;
        Produit reference = entityManagerFactoryUtils.getEntityManager().getReference(Produit.class, produitId);
        entityManagerFactoryUtils.getEntityManager().remove(reference);
        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }

    public void selectProduits() {

    }

    public void selectProduitsByCategorie() {

    }

    public void searchProduitByNom() {

    }


}
