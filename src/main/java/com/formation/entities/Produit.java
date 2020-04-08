package com.formation.entities;

import javax.persistence.*;

@Entity
@Table(name="produit")
public class Produit{

    private long id;
    private String nom;
    private float prix;
    private Categorie categorie;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="produit_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @ManyToOne
    @JoinColumn(name= "categorie_id")
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


}
