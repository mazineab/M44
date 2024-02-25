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
    MutableLiveData<ArrayList<Product>> getAllPrd=new MutableLiveData<>();
    MutableLiveData<ArrayList<Product>> getPrd=new MutableLiveData<>();
    MutableLiveData<ArrayList<Product>> getCloth=new MutableLiveData<>();
    MutableLiveData<ArrayList<Product>> getClothW=new MutableLiveData<>();
    public void Add(Context context) {
        repository=new ProductRepository(context);
        ArrayList<Product> listProducts=new ArrayList<>(repository.getProducts());
        getAllPrd.setValue(listProducts);
    }
    public LiveData<ArrayList<Product>> getProducts(){
        return getAllPrd;
    }

    public void getPhones(){
        getPrd.setValue(repository.getProdutsPhones());
    }
    public LiveData<ArrayList<Product>> getProdusPhones(){
        return getPrd;
    }

    public void getClothMen(){
        getCloth.setValue(repository.getProductsClotheMen());
    }

    public LiveData<ArrayList<Product>> getProductsClothMens(){
        return getCloth;
    }

    public void getClothWomen(){getClothW.setValue(repository.getProductsCloteWomen());}

    public LiveData<ArrayList<Product>> getProductsClothWomens(){
        return getClothW;
    }
}
