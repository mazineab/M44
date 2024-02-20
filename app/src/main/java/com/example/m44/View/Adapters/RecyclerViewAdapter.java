package com.example.m44.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.Product;
import com.example.m44.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<Viewholder> {
    ArrayList<Product> listProducts;
    public RecyclerViewAdapter(ArrayList<Product> listProducts){
        listProducts=listProducts;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product,null,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Product product=listProducts.get(position);
        Picasso.get().load(product.pathImg).into(holder.img);
        holder.id.setText(product.id);
        holder.categorie.setText(product.categorie);
        holder.name.setText(product.name);
        holder.price.setText(product.price+"DH");
        if(product.oldPrice!=0.0)
            holder.oldPrice.setText(product.oldPrice+"DH");
        else
            holder.oldPrice.setText("");

        if(product.remise!=0)
            holder.remise.setText(product.remise+"%");
        else
            holder.remise.setText("");

        if(product.buy!=0)
            holder.buy.setText(product.buy+"");
        else
            holder.buy.setText("");

        if(product.stars!=0.0)
            holder.stars.setText(product.stars+"");
        else
            holder.buy.setText("");

        holder.livrision.setText(product.livraion+"");
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }
}
