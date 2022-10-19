package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    ArrayList<Book> dataBook;

    public void setData(ArrayList<Book> dataPhones) {
        this.dataBook = dataPhones;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_book,parent,false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book phone = dataBook.get(position);
        if (phone == null){
            return;
        }

        holder.txtName.setText(phone.getName());
        holder.imgPhone.setImageResource(phone.getImage());
    }

    @Override
    public int getItemCount() {
        if (dataBook != null) {
            return dataBook.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPhone;
        private TextView txtName;
        private TextView txtPrice;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhone = itemView.findViewById(R.id.img_book);
            txtName = itemView.findViewById(R.id.txt_ten);
        }
    }
}
