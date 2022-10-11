package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListPhim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_phim);
        initView();
    }
    public void initView(){
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.listphim);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<DataPhim> arrPhim = new ArrayList<>();
        arrPhim.add(new DataPhim(R.drawable.img_jurassicworld,"Jurassic World Dominion","147 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_topgun,"Top Gun:: Maverick","131 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_doctorstrange,"Docter Strange in the Multiverse of Madness","126 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_avatar,"Avatar","162 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_morbius,"Morbius","105 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_uncharted,"Uncharted","116 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_kingsman,"The King's Man","131 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_terminator,"The Terminator","108 mins"));
        arrPhim.add(new DataPhim(R.drawable.img_fall,"Fall","107 mins"));
        AdapterPhim adapterPhim = new AdapterPhim(arrPhim,getApplicationContext());
        recyclerView.setAdapter(adapterPhim);
    }
}