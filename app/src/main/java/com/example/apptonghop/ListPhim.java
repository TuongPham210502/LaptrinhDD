package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListPhim extends AppCompatActivity implements InterfaceClickItem{
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvListPhim;


    private ArrayList<Phim> arrPhim;
    private PhimAdapter phimAdapter;
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_phim);


        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menuList);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menuProfile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menuList:
                        return true;
                }
                return false;
            }
        });
        init();
    }
    private void init(){
        rcvListPhim = findViewById(R.id.listphim);
        arrPhim = new ArrayList<>();
        arrPhim.add(new Phim(R.drawable.img_jurassicworld,"Jurassic World Dominion","147 mins", getResources().getString(R.string.jurasic)));
        arrPhim.add(new Phim(R.drawable.img_topgun,"Top Gun: Maverick","131 mins",getResources().getString(R.string.topgun)));
        arrPhim.add(new Phim(R.drawable.img_doctorstrange,"Docter Strange in the Multiverse of Madness","126 mins",getResources().getString(R.string.doctor)));
        arrPhim.add(new Phim(R.drawable.img_avatar,"Avatar","162 mins",getResources().getString(R.string.avatar)));
        arrPhim.add(new Phim(R.drawable.img_morbius,"Morbius","105 mins",getResources().getString(R.string.mobius)));
        arrPhim.add(new Phim(R.drawable.img_uncharted,"Uncharted","116 mins",getResources().getString(R.string.Uncharted)));
        arrPhim.add(new Phim(R.drawable.img_kingsman,"The King's Man","131 mins",getResources().getString(R.string.kingsman)));
        arrPhim.add(new Phim(R.drawable.img_terminator,"The Terminator","108 mins",getResources().getString(R.string.terminator)));
        arrPhim.add(new Phim(R.drawable.img_fall,"Fall","107 mins",getResources().getString(R.string.fall)));


        phimAdapter = new PhimAdapter(arrPhim,this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rcvListPhim.setLayoutManager(gridLayoutManager);
        phimAdapter = new PhimAdapter(arrPhim, new InterfaceClickItem() {
            @Override
            public void onItemClickPhim(Phim phim) {
                goDetail(phim);
            }
        });
        rcvListPhim.setAdapter(phimAdapter);
    }

    @Override
    public void onItemClickPhim(Phim phim) {
    }

    private void goDetail(Phim phim){
        Intent intent = new Intent(this,Detail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("objPhim",phim);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}