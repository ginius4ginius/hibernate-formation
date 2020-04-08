package com.formation.dao;

public interface ProduitDao {

    public void setup();

    public void exit();

    public void create();

    public void read();

    public void update();

    public void delete();

    public void selectProduits();

    public void selectProduitsByCategorie();

    public void searchProduitByNom();

}
