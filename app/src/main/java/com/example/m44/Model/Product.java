package com.example.m44.Model;

public class Product {
    public String id,name,categorie;
    public double price,oldPrice,stars;
    public String pathImg;
    public boolean livraion;
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
    }

}
