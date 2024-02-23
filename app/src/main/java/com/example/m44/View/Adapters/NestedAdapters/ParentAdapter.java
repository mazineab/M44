package com.example.m44.View.Adapters.NestedAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.Model.NestedsClass.Parent;
import com.example.m44.R;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolderP> {
    ArrayList<Parent> listParent;
    static Parent parent;
    Context context;
    public ParentAdapter(ArrayList<Parent> listParent, Context context) {
        this.listParent = listParent;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recy1,null,false);
        return new ViewHolderP(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderP holder, int position) {
        parent=listParent.get(position);
        boolean isHorizontal=parent.isHorizontal;
        holder.tv1.setText(parent.title);
        holder.tv2.setText(parent.title2);

        ChildAdapter childAdapter;
        childAdapter=new ChildAdapter(listParent.get(position).listChild,context);
        if(!isHorizontal){
            holder.rcy.setLayoutManager(new GridLayoutManager(context,2));
        }
        else{
            holder.rcy.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        }


        holder.rcy.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listParent.size();
    }
    public class ViewHolderP extends RecyclerView.ViewHolder {
        TextView tv1,tv2;
        RecyclerView rcy;
        public ViewHolderP(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.titleRecy);
            tv2=itemView.findViewById(R.id.vwRcy);
            rcy=itemView.findViewById(R.id.parentRcy);
        }
    }
}
