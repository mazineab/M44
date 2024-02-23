package com.example.m44.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.R;

import java.util.ArrayList;

public class RecyclerAdapterNeted extends RecyclerView.Adapter<RecyclerAdapterNeted.ViewHolderNested> {
    ArrayList<RecyclerView> listRecycler;
//    boolean isHorizontal;

    public RecyclerAdapterNeted(ArrayList<RecyclerView> listRecycler) {
        this.listRecycler = listRecycler;
//        this.isHorizontal=isHorizontal;
    }

    @NonNull
    @Override
    public ViewHolderNested onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_nested,null,false);
        return new ViewHolderNested(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNested holder, int position) {
//        RecyclerView rcy=listRecycler.get(position);
//        LinearLayoutManager lyM;
//        if(isHorizontal){
//            lyM=new LinearLayoutManager(holder.itemView.getContext(),RecyclerView.HORIZONTAL,false);
//        }
//        else{
//            lyM=new LinearLayoutManager(holder.itemView.getContext(),RecyclerView.HORIZONTAL,false);
//        }
    }

    @Override
    public int getItemCount() {
        return listRecycler.size();
    }

    public class ViewHolderNested extends RecyclerView.ViewHolder {
        RecyclerView rcyNst;

        public ViewHolderNested(@NonNull View itemView) {
            super(itemView);
            rcyNst=itemView.findViewById(R.id.rcyNst);
        }
    }

}
