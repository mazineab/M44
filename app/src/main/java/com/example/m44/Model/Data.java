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
    public Data(){

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
                    String strPrice=prdObj.getString("price").replaceAll("[^\\d.]+","");
                    String strOldPrice=prdObj.getString("oldPrice").replaceAll("[^\\d.]+","");
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
                    double price=0.0;double oldPrice=0.0;double stars=0.0;int remise=0;int buy=0;boolean livrision=false;
                    try{
                        price=Double.parseDouble(strPrice);
                        if(strOldPrice!=null && !strOldPrice.equals("null") && !strOldPrice.isEmpty()){
                            oldPrice=Double.parseDouble(strOldPrice);
                        }else
                            oldPrice=0.0;
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
