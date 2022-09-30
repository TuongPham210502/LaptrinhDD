package com.example.listviewnc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhimAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Phim> phimList;

    public PhimAdapter(Context context, int layout, List<Phim> phimList) {
        this.context = context;
        this.layout = layout;
        this.phimList = phimList;
    }

    @Override
    public int getCount() {
        return phimList.size();
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

        ImageView imgphim = (ImageView) view.findViewById(R.id.imagephim);
        TextView txtTen = (TextView) view.findViewById(R.id.tenphim);
        TextView txtnamsx = (TextView) view.findViewById(R.id.namsx);

        Phim phim = phimList.get(i);

        imgphim.setImageResource(phim.getHinh());
        txtTen.setText(phim.getTen());
        txtnamsx.setText(phim.getNamsx());
        return view;
    }
}
