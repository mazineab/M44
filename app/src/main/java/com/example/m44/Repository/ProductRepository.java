package com.example.m44.Repository;

import android.content.Context;

import com.example.m44.Model.Data;
import com.example.m44.Model.Product;

import java.util.ArrayList;

public class ProductRepository {
    Context contextt;
    public Data data;

    public ProductRepository(Context context){
        contextt=context;
        data=new Data();
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> listPrd=new ArrayList<>(data.getJsonData(contextt));
        return listPrd;
    }
    
}
