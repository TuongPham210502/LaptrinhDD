package com.example.qlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.qlysinhvien.R;
import com.example.qlysinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhVienList328;
    private Context context328;

    public SinhVienAdapter(Context context,List<SinhVien> sinhVienList) {
        this.sinhVienList328 = sinhVienList;
        this.context328 = context;
    }

    @Override
    public int getCount() {
        return sinhVienList328.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context328.getSystemService(context328.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sinhvien,null);

            viewHolder.txtMaSV328 = view.findViewById(R.id.txtMaSV);
            viewHolder.txtHoten328 = view.findViewById(R.id.txtTenSV);
            viewHolder.txtEmail328 = view.findViewById(R.id.txtEmail);
            viewHolder.txtSoDT328 = view.findViewById(R.id.txtSoDt);
            viewHolder.imgGioitinh328 = view.findViewById(R.id.imgGioitinh);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        SinhVien sinhVien = sinhVienList328.get(i);
        viewHolder.txtMaSV328.setText("Mã SV: "+sinhVien.getMaSV());
        viewHolder.txtHoten328.setText(sinhVien.getHoten());
        viewHolder.txtEmail328.setText("Email: "+sinhVien.getEmail());
        viewHolder.txtSoDT328.setText("Số điện thoại: "+sinhVien.getSoDT());

        if(sinhVien.getGioitinh()==0){
            viewHolder.imgGioitinh328.setImageResource(R.drawable.woman);
        }
        else{
            viewHolder.imgGioitinh328.setImageResource(R.drawable.man);
        }

        return view;
    }

    class ViewHolder{
        TextView txtHoten328,txtMaSV328,txtEmail328,txtSoDT328;
        ImageView imgGioitinh328;
    }
}
