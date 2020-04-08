package com.formation.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CommandePK implements Serializable {

    private long utilisateurId;
    private long produitId;

    @Column(name = "utilisateur_id")
    @Id
    public long getUtilisateureId() {
        return utilisateurId;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    @Column(name = "produit_id")
    @Id
    public long getProduitId() {
        return produitId;
    }

    public void setProduitId(long techniqueId) {
        this.produitId = produitId;
    }
}
