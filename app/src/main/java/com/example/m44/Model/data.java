package com.example.m44.Model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class data {
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
                    String strPrice=prdObj.getString("price").replace("[^\\d.]+","");
                    String strOldPrice=prdObj.getString("oldPrice").replace("[^\\d.]+","");
                    String strRemise=prdObj.getString("remise");
                    String strStars=prdObj.getString("stars").replace(" out of 5","");
                    String strBuy=prdObj.getString("buy");
                    String strLivrision=prdObj.getString("livrision");
                    double price=0.0;double oldPrice=0.0;double stars=0.0;int remise=0;int buy=0;boolean livrision=false;
                    try{
                        price=Double.parseDouble(strPrice);
                        oldPrice=Double.parseDouble(strOldPrice);
                        stars=Double.parseDouble(strStars);
                        buy=Integer.parseInt(strBuy);
                        remise=Integer.parseInt(strRemise);
                        livrision=Boolean.parseBoolean(strLivrision);
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
