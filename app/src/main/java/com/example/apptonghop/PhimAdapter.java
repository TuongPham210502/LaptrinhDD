package com.example.apptonghop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.apptonghop.iterface.IClickItem;

import java.util.ArrayList;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.PhimAdapterViewHolder>{
    private ArrayList<Phim> phimData;
    private InterfaceClickItem interfaceClickItem;


    public PhimAdapter(ArrayList<Phim> phimData,InterfaceClickItem interfaceClickItem) {
        this.phimData = phimData;
        this.interfaceClickItem = interfaceClickItem;
    }


    @NonNull
    @Override
    public PhimAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new PhimAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimAdapterViewHolder holder, int position) {
        holder.bindData(phimData.get(position));
    }

    @Override
    public int getItemCount() {
        return phimData.size();
    }

    public class PhimAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView tenphim;
        private Phim phim;
        private ImageView hinhphim;
        private TextView thgian;

        public PhimAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceClickItem.onItemClickPhim(phim);
                }
            });

            tenphim = itemView.findViewById(R.id.txttenphim);
            hinhphim = itemView.findViewById(R.id.imgphim);
            thgian = itemView.findViewById(R.id.txtthgian);

        }
        private void bindData(Phim phim){
            this.phim = phim;
            tenphim.setText(phim.getTenPhim());
            hinhphim.setImageResource(phim.getHinhPhim());
            thgian.setText(phim.getThGian());

        }
    }
}