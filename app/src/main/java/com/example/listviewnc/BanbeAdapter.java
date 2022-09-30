package com.example.listviewnc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BanbeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Banbe> banbeList;

    public BanbeAdapter(Context context, int layout, List<Banbe> banbeList) {
        this.context = context;
        this.layout = layout;
        this.banbeList = banbeList;
    }

    @Override
    public int getCount() {
        return banbeList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        //anh xa view
        ImageView imgavt = (ImageView) view.findViewById(R.id.avatar);
        TextView txtTen = (TextView) view.findViewById(R.id.tenbanbe);
        TextView txtgtinh = (TextView) view.findViewById(R.id.gioitinh);

        //gan gia tri
        Banbe banbe = banbeList.get(i);

        imgavt.setImageResource(banbe.getHinh());
        txtTen.setText(banbe.getTen());
        txtgtinh.setText(banbe.getGtinh());

        return view;
    }
}
