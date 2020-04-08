package com.formation.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "categorie")
public class Categorie {

    private long id;
    private String nom;
    private Set<Produit> produits;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    @Id
    @Column(name = "categorie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getId() {
        return id;
    }


    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    public Set<Produit> getProduits() {
        return produits;
    }

    public String getNom() {
        return nom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
