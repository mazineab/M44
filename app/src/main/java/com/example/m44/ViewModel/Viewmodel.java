package com.example.m44.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.m44.Model.Product;
import com.example.m44.Repository.ProductRepository;

import java.util.ArrayList;

public class Viewmodel extends ViewModel {
    ProductRepository repository;
    MutableLiveData<ArrayList<Product>> getPrd=new MutableLiveData<>();
    public void Add(Context context) {
        repository=new ProductRepository(context);
        ArrayList<Product> listProducts=new ArrayList<>(repository.getProducts());
        getPrd.setValue(listProducts);
    }
    public LiveData<ArrayList<Product>> getProducts(){
        return getPrd;
    }
}
