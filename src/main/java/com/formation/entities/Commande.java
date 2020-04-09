package com.formation.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commande")
@IdClass(CommandePK.class)
public class Commande {

    @Id
    @Column(name = "utilisateur_id")
    private long utilisateurId;

    @Id
    @Column(name = "produit_id")
    private long produitId;
    private Date dateCommande;


    public long getUtilisateurId() {
        return utilisateurId;
    }

    public long getProduitId() {
        return produitId;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setProduitId(long produitId) {
        this.produitId = produitId;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
}
