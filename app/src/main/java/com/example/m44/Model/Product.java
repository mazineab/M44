package com.example.m44.Model;

public class Product {
    String id,name,categorie;
    String price,oldPrice,remise;
    String pathImg,stars;
    boolean livraion;
    int buy;

    public Product(String id, String name, String categorie, String price, String oldPrice, String remise, String pathImg, String stars, boolean livraion, int buy) {
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
    }

}
