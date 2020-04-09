package com.formation.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CommandePK implements Serializable {

    private long utilisateurId;
    private long produitId;


    public long getUtilisateureId() {
        return utilisateurId;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public long getProduitId() {
        return produitId;
    }

    public void setProduitId(long techniqueId) {
        this.produitId = produitId;
    }

    public CommandePK(){}

    public CommandePK(long utilisateurId, long produitId){
        this.utilisateurId = utilisateurId;
        this.produitId = produitId;
    }
}
