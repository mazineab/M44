package com.example.m44.View.Adapters.NestedAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.NestedsClass.Child;
import com.example.m44.R;
import com.example.m44.View.ProductDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolderCh> {
    ArrayList<Child> listChild;
    Context context;

    public ChildAdapter(ArrayList<Child> listChild, Context context) {
        this.listChild = listChild;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolderCh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        boolean isHorizontal=ParentAdapter.parent.isHorizontal;
        View view;
        if(!isHorizontal){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_vrt,null,false);
        }
        else{
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_horizontal,null,false);
        }
        return new ViewHolderCh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCh holder, int position) {
        Child child=listChild.get(position);
        Picasso.get().load(child.image).into(holder.img);
        holder.name.setText(child.name);
        holder.prc.setText(child.price+"DH");
        holder.oldPrc.setText(child.price+"DH");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ProductDetails.class);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listChild.size();
    }
    public class ViewHolderCh extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,prc,oldPrc;
        public ViewHolderCh(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgHz2);
            name=itemView.findViewById(R.id.nameHz);
            prc=itemView.findViewById(R.id.prcHZ1);
            oldPrc=itemView.findViewById(R.id.oldPrcHz);
        }
    }
}
