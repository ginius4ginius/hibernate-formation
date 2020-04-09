package com.formation.dao;

import com.formation.dao.utils.SessionFactoryUtils;
import com.formation.entities.*;
import org.hibernate.Session;

import java.util.Date;

public class CommandeDaoSessionFactory implements Dao {

    SessionFactoryUtils utils = new SessionFactoryUtils();

    public void create() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        Utilisateur u = new Utilisateur("pierre");

        session.save(u);

        Produit produit = session.find(Produit.class, 3L);
        Utilisateur utilisateur = session.find(Utilisateur.class, 1L);

        Commande commande = new Commande();
        commande.setProduitId(produit.getId());
        commande.setUtilisateurId(utilisateur.getId());
        commande.setDateCommande(new Date());

        session.save(commande);

        session.getTransaction().commit();
        session.close();

    }

    public void read() {

        Session session = utils.getSessionFactory().openSession();

        CommandePK pk = new CommandePK(1L,3L);
        Commande commande = session.find(Commande.class,pk);

        System.out.println("PK_produit: " + commande.getProduitId());
        System.out.println("PK_utilisateur: " + commande.getUtilisateurId());
        System.out.println("Date commande: " + commande.getDateCommande());

        session.close();

    }

    public void update() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        CommandePK pk = new CommandePK(1L,3L);
        Commande commande = session.find(Commande.class,pk);
        commande.setDateCommande(new Date());

        session.update(commande);

        session.getTransaction().commit();
        session.close();

    }

    public void delete() {

        Session session = utils.getSessionFactory().openSession();
        session.beginTransaction();

        CommandePK pk = new CommandePK(1L,3L);
        Commande commande = session.find(Commande.class,pk);

        session.delete(commande);

        session.getTransaction().commit();
        session.close();
    }

}
