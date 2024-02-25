package com.example.m44.Model;

import java.io.Serializable;

public class Product implements Serializable {
    public String id,name,categorie;
    public double price,oldPrice,stars;
    public String pathImg;
    public boolean livraion,favorite;
    public int buy,remise;

    public Product(String id, String name, String categorie, double price, double oldPrice, int remise, String pathImg, double stars, boolean livraion, int buy) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.price = price;
        this.oldPrice = oldPrice;
        this.remise = remise;
        this.pathImg = pathImg;
        this.stars = stars;
        this.livraion = livraion;
        this.buy = buy;
        this.favorite=false;
    }

    public Product(String id, String name, String categorie, double price, double oldPrice, int remise, String pathImg, double stars, boolean livraion, int buy,boolean favorite) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.price = price;
        this.oldPrice = oldPrice;
        this.remise = remise;
        this.pathImg = pathImg;
        this.stars = stars;
        this.livraion = livraion;
        this.buy = buy;
        this.favorite=favorite;
    }
    public Product(){

    }


}
