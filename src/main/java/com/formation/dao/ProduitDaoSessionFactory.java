package com.formation.dao;

import com.formation.dao.utils.SessionFactoryUtils;

import com.formation.entities.Categorie;
import com.formation.entities.Produit;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProduitDaoSessionFactory implements ProduitDao, Dao {

    SessionFactoryUtils utils = new SessionFactoryUtils();

    public void create() {


        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        Produit produit = new Produit();
        produit.setNom("Bonbon à la menthe");
        produit.setPrix(1.5f);

        Categorie produitCategorie = session.find(Categorie.class, 1L);
        //System.out.println(produitCategorie.getNom());
        produit.setCategorie(produitCategorie);

        session.save(produit);

        Produit produit2 = new Produit();
        produit2.setNom("Bonbon à la fraise des bois");
        produit2.setPrix(2.0f);

        Categorie produitCategorie2 = session.find(Categorie.class, 1L);
        produit2.setCategorie(produitCategorie2);

        session.save(produit2);

        session.getTransaction().commit();
        session.close();
    }


    public void read() {

        Session session = utils.getSessionFactory().openSession();

        long produitId = 1;
        Produit produit = session.get(Produit.class, produitId);

        System.out.println("Nom: " + produit.getNom());
        System.out.println("Prix: " + produit.getPrix());

        session.close();

    }


    public void update() {

        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("Bonbon à la menthe");
        produit.setPrix(2.5f);

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(produit);

        session.getTransaction().commit();
        session.close();

    }


    public void delete() {

        Produit produit = new Produit();
        produit.setId(1);

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(produit);

        session.getTransaction().commit();
        session.close();

    }

    public void selectProduits() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Produit";
        Query query = session.createQuery(hql);
        List<Produit> listProduits = query.list();
        session.getTransaction().commit();
        session.close();

        for (Produit p : listProduits) {
            System.out.println(p.getNom());
        }
    }

    public void selectProduitsByCategorie() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Produit where categorie.nom = 'sucrerie'";
        Query query = session.createQuery(hql);
        List<Produit> listProduits = query.list();

        for (Produit p : listProduits) {
            System.out.println(p.getNom());
        }

        session.getTransaction().commit();
        session.close();
    }

    public void searchProduitByNom() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "from Produit where nom like :keyword";

        String keyword = "fr";
        Query query = session.createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");

        List<Produit> listProduits = query.list();

        for (Produit p : listProduits) {
            System.out.println(p.getNom());
        }

        session.getTransaction().commit();
        session.close();
    }


}
