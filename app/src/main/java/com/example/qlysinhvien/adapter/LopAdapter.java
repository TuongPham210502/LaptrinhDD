package com.example.qlysinhvien.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlysinhvien.InterfaceClickItem;
import com.example.qlysinhvien.R;
import com.example.qlysinhvien.model.Lop;

import java.util.ArrayList;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopAdapteViewHolder> {
    private ArrayList<Lop> lopData;
    private InterfaceClickItem interfaceClickItem;

    public LopAdapter(ArrayList<Lop> lopData, InterfaceClickItem interfaceClickItem) {
        this.lopData = lopData;
        this.interfaceClickItem = interfaceClickItem;
    }
    @NonNull
    @Override
    public LopAdapteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop,parent,false);
        return new LopAdapteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopAdapteViewHolder holder, int position) {
        holder.bindData(lopData.get(position));
    }

    @Override
    public int getItemCount() {
        return lopData.size();
    }

    public class LopAdapteViewHolder extends RecyclerView.ViewHolder{
        private TextView tenlop;
        private Lop lop;
        public LopAdapteViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceClickItem.onItemClickLop(lop);
                }
            });
            tenlop = itemView.findViewById(R.id.txtLop);
        }

        private void bindData(Lop lop){
            this.lop = lop;
            tenlop.setText(lop.getLop());
        }
    }

}
