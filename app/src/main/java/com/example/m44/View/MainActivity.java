package com.example.m44.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.Product;
import com.example.m44.R;
import com.example.m44.View.Adapters.RecyclerViewAdapter;
import com.example.m44.ViewModel.Viewmodel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerViewAdapter ad;
    RecyclerView rcy;
    ArrayList<Product> list;
    Viewmodel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcy=findViewById(R.id.rcy);
        viewmodel=new ViewModelProvider(MainActivity.this).get(Viewmodel.class);
        list=new ArrayList<>();
        ad=new RecyclerViewAdapter(list);
        LinearLayoutManager lytM=new LinearLayoutManager(this);
        rcy.setHasFixedSize(true);
        rcy.setLayoutManager(lytM);
        rcy.setAdapter(ad);
        viewmodel.Add(MainActivity.this);
        viewmodel.getProducts().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                list.addAll(products);
            }
        });


    }


}