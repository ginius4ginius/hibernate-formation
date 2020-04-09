package com.formation.dao;

public interface ProduitDao extends Dao {

    public void selectProduits();

    public void selectProduitsByCategorie();

    public void searchProduitByNom();

}
