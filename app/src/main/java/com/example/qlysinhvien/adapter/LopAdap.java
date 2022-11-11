package com.example.qlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlysinhvien.R;
import com.example.qlysinhvien.model.Lop;

import java.util.List;

public class LopAdap extends BaseAdapter {
    private List<Lop> listLop;
    private Context context328;

    public LopAdap(Context context, List<Lop> listLop ) {
        this.listLop = listLop;
        this.context328 = context;
    }


    @Override
    public int getCount() {
        return listLop.size();
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
            viewHolder = new LopAdap.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context328.getSystemService(context328.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_lop,null);

            viewHolder.txtLop = view.findViewById(R.id.txtLop);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (LopAdap.ViewHolder) view.getTag();
        }
        Lop lop = listLop.get(i);
        viewHolder.txtLop.setText("Mã SV: "+lop.getLop());

        return view;
    }
    class ViewHolder{
        TextView txtLop;
    }
}
