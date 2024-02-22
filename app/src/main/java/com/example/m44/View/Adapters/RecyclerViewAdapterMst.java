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

public class RecyclerViewAdapterMst extends RecyclerView.Adapter<ViewHolderMst> {
    ArrayList<Product> listPrd;

    public RecyclerViewAdapterMst(ArrayList<Product> listPrd) {
        this.listPrd = listPrd;
    }

    @NonNull
    @Override
    public ViewHolderMst onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_horizontal,null,false);
        return new ViewHolderMst(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMst holder, int position) {
        Product product=listPrd.get(position);
        holder.nameHz.setText(product.name);
        Picasso.get().load(product.pathImg).into(holder.img);
        holder.prcHz.setText(product.price+" DH");
        if(product.oldPrice!=0.0){
            holder.oldPrcHz.setText(product.oldPrice+" DH");
        }
        else{
            holder.oldPrcHz.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return listPrd.size();
    }
}
