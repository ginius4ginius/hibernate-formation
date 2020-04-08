package com.formation.entities;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    private long id;
    private String nom;

    public Utilisateur() {
    }

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    @Id
    @Column(name = "utilisateur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
