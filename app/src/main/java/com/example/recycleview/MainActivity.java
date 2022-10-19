package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private ArrayList<Category> getListCategory(){
        ArrayList<Category> listCategory = new ArrayList<>();

        //Category 1
        ArrayList<Book> list_book = new ArrayList<>();
        list_book.add(new Book("Book 1",  R.drawable.baihoccuocsong));
        list_book.add(new Book("Book 2",  R.drawable.chienthangconquytrongban));
        list_book.add(new Book("Book 3",  R.drawable.cuocsongcuocdoi));
        list_book.add(new Book("Book 4",  R.drawable.dacnhantam));
        list_book.add(new Book("Book 5",  R.drawable.ditimlesong));

        ArrayList<Book> list_book2 = new ArrayList<>();
        list_book2.add(new Book("Book 1",  R.drawable.baihoccuocsong));
        list_book2.add(new Book("Book 2",  R.drawable.chienthangconquytrongban));
        list_book2.add(new Book("Book 3",  R.drawable.cuocsongcuocdoi));
        list_book2.add(new Book("Book 4",  R.drawable.dacnhantam));
        list_book2.add(new Book("Book 5",  R.drawable.ditimlesong));

        ArrayList<Book> list_book3 = new ArrayList<>();
        list_book3.add(new Book("Book 1",  R.drawable.baihoccuocsong));
        list_book3.add(new Book("Book 2",  R.drawable.chienthangconquytrongban));
        list_book3.add(new Book("Book 3",  R.drawable.cuocsongcuocdoi));
        list_book3.add(new Book("Book 4",  R.drawable.dacnhantam));
        list_book3.add(new Book("Book 5",  R.drawable.ditimlesong));


        listCategory.add(new Category("Category 1", list_book));
        listCategory.add(new Category("Category 2", list_book2));
        listCategory.add(new Category("Category 3", list_book3));

        return listCategory;
    }
}