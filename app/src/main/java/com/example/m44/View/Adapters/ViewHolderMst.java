package com.example.m44.View.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m44.R;

public class ViewHolderMst extends RecyclerView.ViewHolder {
    ImageView img;
    TextView prcHz,oldPrcHz,nameHz;

    public ViewHolderMst(@NonNull View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.imgHz2);
        prcHz=itemView.findViewById(R.id.prcHZ1);
        oldPrcHz=itemView.findViewById(R.id.oldPrcHz);
        nameHz=itemView.findViewById(R.id.nameHz);
    }
}
