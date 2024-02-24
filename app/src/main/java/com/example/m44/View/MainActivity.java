package com.example.m44.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.NestedsClass.Child;
import com.example.m44.Model.NestedsClass.Parent;
import com.example.m44.Model.Product;
import com.example.m44.R;
import com.example.m44.View.Adapters.NestedAdapters.ParentAdapter;
import com.example.m44.ViewModel.Viewmodel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ParentAdapter adNstd;
    RecyclerView rcy;
    Viewmodel viewmodel;
    ArrayList<Parent> listParents;
    ArrayList<Child> lisChild1,listChild2,listAllPrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listParents=new ArrayList<>();
        lisChild1=new ArrayList<>();
        listChild2=new ArrayList<>();
        listAllPrd=new ArrayList<>();
        rcy=findViewById(R.id.rcy);


//        ImageSlider imgSldr=findViewById(R.id.sldr1);
//        ArrayList<SlideModel> slids=new ArrayList<>();
//        slids.add(new SlideModel(R.drawable.im1, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im2, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im3, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im4, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im5, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im6, ScaleTypes.FIT));
//        slids.add(new SlideModel(R.drawable.im7, ScaleTypes.FIT));
//        imgSldr.setImageList(slids,ScaleTypes.FIT);




        viewmodel=new ViewModelProvider(MainActivity.this).get(Viewmodel.class);

        viewmodel.Add(MainActivity.this);
        viewmodel.getProducts().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                for(Product prd:products){
                    listAllPrd.add(new Child(prd.name,String.valueOf(prd.price),String.valueOf(prd.oldPrice),prd.pathImg));
                }
            }
        });
        viewmodel.getClothMen();
        viewmodel.getProductsClothMens().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                for(Product prd:products){
                    lisChild1.add(new Child(prd.name,String.valueOf(prd.price),String.valueOf(prd.oldPrice),prd.pathImg));
                }
            }
        });
        listParents.add(new Parent("Most Populaire","View All",lisChild1));

        viewmodel.getPhones();
        viewmodel.getProdusPhones().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                for(Product prd:products){
                    listChild2.add(new Child(prd.name,String.valueOf(prd.price),String.valueOf(prd.oldPrice),prd.pathImg));
                }
            }
        });
        listParents.add(new Parent("Thrends Of Week","View All",listChild2));


        listParents.add(new Parent(listAllPrd,false));

        adNstd=new ParentAdapter(listParents,MainActivity.this);
        LinearLayoutManager lytM=new LinearLayoutManager(this);
        rcy.setLayoutManager(lytM);
        rcy.setAdapter(adNstd);


















    }


}