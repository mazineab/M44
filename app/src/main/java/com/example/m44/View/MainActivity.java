package com.example.m44.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.NestedsClass.Parent;
import com.example.m44.Model.Product;
import com.example.m44.R;
import com.example.m44.View.Adapters.NestedAdapters.ParentAdapter;
import com.example.m44.ViewModel.Viewmodel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText edSrch;
    ParentAdapter adNstd;
    RecyclerView rcy;
    Viewmodel viewmodel;
    static ArrayList<Product> listProduts;
    ArrayList<Parent> listParents;
    ArrayList<Product> lisChild1,listChild2,listAllPrd;
    public static Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSrch=findViewById(R.id.edSrch);
        listParents=new ArrayList<>();
        lisChild1=new ArrayList<>();
        listChild2=new ArrayList<>();
        listAllPrd=new ArrayList<>();
        listProduts=new ArrayList<>();
        rcy=findViewById(R.id.rcy);
        edSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edSrch.requestFocus();
            }
        });


        viewmodel=new ViewModelProvider(MainActivity.this).get(Viewmodel.class);

        viewmodel.Add(MainActivity.this);

        viewmodel.getProducts().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listAllPrd.addAll(products);
                    }
                }).start();
            }
        });


        adNstd=new ParentAdapter(listParents,MainActivity.this);
        LinearLayoutManager lytM=new LinearLayoutManager(MainActivity.this);
        rcy.setLayoutManager(lytM);
        rcy.setAdapter(adNstd);



        viewmodel.getClothMen();
        viewmodel.getProductsClothMens().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lisChild1.addAll(products);
                    }
                }).start();

            }
        });
        listParents.add(new Parent("Most Populaire","View All",lisChild1));

        viewmodel.getPhones();
        viewmodel.getProdusPhones().observe(MainActivity.this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listChild2.addAll(products);
                    }
                }).start();

            }
        });
        listParents.add(new Parent("Thrends Of Week","View All",listChild2));


        listParents.add(new Parent(listAllPrd,false));


    }
//    public static Product getClickedProduct(String id){
//        Product product = new Product();
//        for(Product prd:listProduts){
//            if(prd.id.equals(id)){
//                product=prd;
//                break;
//            }
//        }
//        return product;
//    }


}