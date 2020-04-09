package com.formation.dao;

import com.formation.dao.utils.EntityManagerFactoryUtils;
import com.formation.entities.Commande;
import com.formation.entities.CommandePK;
import com.formation.entities.Produit;
import com.formation.entities.Utilisateur;

import java.util.Date;

public class CommandeDaoEntityManagerFactory implements Dao {

    private EntityManagerFactoryUtils entityManagerFactoryUtils = new EntityManagerFactoryUtils();


    public void create() {

        Utilisateur u = new Utilisateur("paul");
        entityManagerFactoryUtils.getEntityManager().persist(u);

        Produit produit = entityManagerFactoryUtils.getEntityManager().find(Produit.class, 3L);
        Utilisateur utilisateur = entityManagerFactoryUtils.getEntityManager().find(Utilisateur.class, 2L);

        Commande commande = new Commande();
        commande.setProduitId(produit.getId());
        commande.setUtilisateurId(utilisateur.getId());
        commande.setDateCommande(new Date());

        entityManagerFactoryUtils.getEntityManager().persist(commande);

        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }


    public void read() {

        CommandePK pk = new CommandePK(2L,3L);
        Commande commande = entityManagerFactoryUtils.getEntityManager().find(Commande.class,pk);

        System.out.println("PK_produit: " + commande.getProduitId());
        System.out.println("PK_utilisateur: " + commande.getUtilisateurId());
        System.out.println("Date commande: " + commande.getDateCommande());

    }


    public void update() {

        CommandePK pk = new CommandePK(2L,3L);
        Commande commande = entityManagerFactoryUtils.getEntityManager().find(Commande.class,pk);
        commande.setDateCommande(new Date());

        entityManagerFactoryUtils.getEntityManager().merge(commande);
        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }


    public void delete() {

        CommandePK pk = new CommandePK(2L,3L);
        Commande commande = entityManagerFactoryUtils.getEntityManager().getReference(Commande.class,pk);
        entityManagerFactoryUtils.getEntityManager().remove(commande);
        entityManagerFactoryUtils.getEntityManager().getTransaction().commit();

    }

}
