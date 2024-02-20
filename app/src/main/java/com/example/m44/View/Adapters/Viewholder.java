package com.example.m44.View.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.R;

public class Viewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView id,categorie,name,price,oldPrice,remise,stars,buy,livrision;
    public Viewholder(@NonNull View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.img);
        id=itemView.findViewById(R.id.id);
        categorie=itemView.findViewById(R.id.cat);
        name=itemView.findViewById(R.id.name);
        remise=itemView.findViewById(R.id.rem);
        stars=itemView.findViewById(R.id.str);
        price=itemView.findViewById(R.id.prc);
        oldPrice=itemView.findViewById(R.id.prco);
        buy=itemView.findViewById(R.id.by);
        livrision=itemView.findViewById(R.id.lv);
    }
}
