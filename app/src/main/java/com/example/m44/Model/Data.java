package com.example.m44.Model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Data {
    public ArrayList<Product> productsPhone=new ArrayList<>();
    public ArrayList<Product> productsAccessoriesMen=new ArrayList<>();
    public ArrayList<Product> productsTelevesion=new ArrayList<>();
    public ArrayList<Product> productsLaptop=new ArrayList<>();
    public ArrayList<Product> productsDecoration=new ArrayList<>();
    public ArrayList<Product> productsWomensClothes=new ArrayList<>();
    public ArrayList<Product> productsMensClothes=new ArrayList<>();
    public ArrayList<Product> productsShoes=new ArrayList<>();
    public ArrayList<Product> productsaccessories=new ArrayList<>();
    public Data(){

    }
    public ArrayList<Product> getProductsPhone(){
        return productsPhone;
    }
    public ArrayList<Product> getProductsTelevesion(){
        return productsTelevesion;
    }
    public ArrayList<Product> getProductsLaptop(){
        return productsLaptop;
    }
    public ArrayList<Product> getProductsDecoration(){
        return productsDecoration;
    }
    public ArrayList<Product> getProductsWomensClothes(){
        return productsWomensClothes;
    }
    public ArrayList<Product> getProductsAccessoriesMen(){
        return productsAccessoriesMen;
    }
    public ArrayList<Product> getProductsShoes(){
        return productsShoes;
    }
    public ArrayList<Product> getProductsMensClothes(){
        return productsMensClothes;
    }
    public ArrayList<Product> getProductsaccessories(){
        return productsaccessories;
    }
    public ArrayList<Product> getJsonData(Context context){
        ArrayList<Product> products=new ArrayList<>();
        String json=loadJsonData("data.json",context);
        if(json!=null){
            try{
                JSONObject jsnObj=new JSONObject(json);
                JSONArray jsnArr=jsnObj.getJSONArray("Product");
                for(int i=0;i<jsnArr.length();i++){
                    JSONObject prdObj=jsnArr.getJSONObject(i);
                    String categorie=prdObj.getString("Categorie");
                    String id=prdObj.getString("id");
                    String name=prdObj.getString("name");
                    String imgSrc=prdObj.getString("img");

                    String strPrice=prdObj.getString("price");
                    double price = 0.0;
                    String[] priceParts = strPrice.split(" - ");
                    String firstPriceStr = priceParts[0].replaceAll("[^\\d.,]+", "").replaceAll(",", "");
                    try {
                        price = Double.parseDouble(firstPriceStr);
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }


                    String strOldPrice=prdObj.getString("oldPrice");
                    double oldPrice = 0.0;
                    if(strOldPrice!=null && !strOldPrice.equals("null") && !strOldPrice.isEmpty()) {
                        String[] oldPriceParts = strOldPrice.split(" - ");
                        String firstOld = oldPriceParts[0].replaceAll("[^\\d.,0]+", "").replaceAll(",", "");
                        try {
                            oldPrice = Double.parseDouble(firstOld);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        oldPrice=0.0;
                    }

                    String strRemise=prdObj.getString("remise").replace("%","");
                    String strStars1="";
                    String strStars=prdObj.getString("stars");
                    if(strStars!=null){
                        strStars1=strStars.replace(" out of 5","");
                    }
                    else{
                        strStars1=null;
                    }

                    String strBuy=prdObj.getString("buy");
                    String strLivrision=prdObj.getString("livrision");
                    double stars=0.0;int remise=0;int buy=0;boolean livrision=false;
                    try{
                        if(strStars1!=null && !strStars1.equals("null")){
                            stars=Double.parseDouble(strStars1);
                        }
                        else
                            stars=0.0;
                        if(strBuy!=null && !strBuy.equals("null")){
                            buy=Integer.parseInt(strBuy);
                        }
                        else
                            buy=0;
                        if(strRemise!=null && !strRemise.equals("null")){
                            remise=Integer.parseInt(strRemise);
                        }
                        else
                            remise=0;
                        if(strLivrision!=null && !strLivrision.equals("null")){
                            livrision=Boolean.parseBoolean(strLivrision);
                        }
                        else
                            livrision=false;



                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    Product product=new Product(id,name,categorie,price,oldPrice,remise,imgSrc,stars,livrision,buy);
                    products.add(product);
                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        else{
            Product prd=new Product("img","name","categorie",20.0,10.0,4,"img",4.5,true,100);
            products.add(prd);
        }

        for(Product prd:products){
            switch (prd.categorie){
                case "Phone":
                    productsPhone.add(prd);
                    break;
                case "Televesion":
                    productsTelevesion.add(prd);
                    break;
                case "Laptop":
                    productsLaptop.add(prd);
                    break;
                case "Decoration":
                    productsDecoration.add(prd);
                    break;
                case "Women's Clothes.":
                    productsWomensClothes.add(prd);
                    break;
                case "Men's Clothes.":
                    productsMensClothes.add(prd);
                    break;
                case "Shoes":
                    productsShoes.add(prd);
                    break;
                case "accessories":
                    productsaccessories.add(prd);
                    break;
                case "Accessories Men":
                    productsAccessoriesMen.add(prd);
                    break;
            }
        }
        return products;


    }
    public String loadJsonData(String s,Context context){
        String json;
        try{
            InputStream getData=context.getAssets().open(s);
            int size=getData.available();
            byte[] buffer=new byte[size];
            getData.read(buffer);
            getData.close();
            json=new String(buffer, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            return  null;
        }
        return json;
    }
}
