package com.example.apptonghop;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPhim extends RecyclerView.Adapter<AdapterPhim.ViewHolder> {
    ArrayList<DataPhim> dataPhim;
    Context context;

    public AdapterPhim(ArrayList<DataPhim> dataPhim, Context context) {
        this.dataPhim = dataPhim;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPhim.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview =layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhim.ViewHolder holder, int position) {
        holder.txtTenPhim.setText(dataPhim.get(position).getTenPhim());
        holder.imgPhim.setImageResource(dataPhim.get(position).getHinhPhim());
        holder.txtThgian.setText(dataPhim.get(position).getThoigian());
    }

    @Override
    public int getItemCount() {
        return dataPhim.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhim;
        TextView txtTenPhim;
        TextView txtThgian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenPhim = (TextView) itemView.findViewById(R.id.txttenphim);
            txtThgian = (TextView) itemView.findViewById(R.id.txtthgian);
            imgPhim = (ImageView) itemView.findViewById(R.id.imgphim);
        }
    }
}
