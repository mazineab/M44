package com.example.m44.View;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
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
    EditText edSrch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSrch=findViewById(R.id.edSrch);

        ImageSlider imgSldr=findViewById(R.id.sldr1);
        ArrayList<SlideModel> slids=new ArrayList<>();
        slids.add(new SlideModel(R.drawable.im1, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im2, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im3, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im4, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im5, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im6, ScaleTypes.FIT));
        slids.add(new SlideModel(R.drawable.im7, ScaleTypes.FIT));
        imgSldr.setImageList(slids,ScaleTypes.FIT);





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