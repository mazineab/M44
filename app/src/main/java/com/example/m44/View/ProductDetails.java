package com.example.m44.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m44.Model.Product;
import com.example.m44.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ProductDetails extends AppCompatActivity {
    ImageView imgPrd,stPrd;
    ImageButton fav;
    TextView namePrd,catPrd,prcPrd,oldPrd,starsPrd,buyPrd,shpPrd;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_activity);
        imgPrd=findViewById(R.id.imgPrd);
        stPrd=findViewById(R.id.stPrd);
        fav=findViewById(R.id.favPrd);
        namePrd=findViewById(R.id.NamePrd);
        catPrd=findViewById(R.id.catPrd);
        prcPrd=findViewById(R.id.prcPrd);
        oldPrd=findViewById(R.id.oldPrd);
        starsPrd=findViewById(R.id.starsPrd);
        buyPrd=findViewById(R.id.buyPrd);
        shpPrd=findViewById(R.id.shpPrd);
        btnAdd=findViewById(R.id.AddCart);



        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        String pathImg=product.pathImg;
        String categ=product.categorie;
        String name=product.name;
        double price=product.price;
        double oldPrice=product.oldPrice;
        int buy=product.buy;
        boolean livr=product.livraion;
        double stars=product.stars;
        boolean favr=product.favorite;

        Picasso.get().load(pathImg).into(imgPrd);
        catPrd.setText(categ);
        namePrd.setText(name);
        prcPrd.setText(price+" DH");
        if(oldPrice!=0.0){
            oldPrd.setText(oldPrice+" DH");
        }
        oldPrd.setText("");

        if(buy!=0){
            buyPrd.setText("(buy)");
        }
        buyPrd.setText("");
        if(livr){
           shpPrd.setText("Free");
        }
        else{
            Random rd=new Random();
            int pay = rd.nextInt(21) + 10;
            shpPrd.setText(pay+" ");
        }
        if(stars!=0.0){
            stPrd.setImageResource(R.drawable.stars);
            starsPrd.setText(stars+"");
        }
        else{
            starsPrd.setText(stars+"");
        }
        if(favr){
            fav.setImageResource(R.drawable.fav_clr);
        }

    }
}