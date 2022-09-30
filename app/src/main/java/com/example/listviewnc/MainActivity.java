package com.example.listviewnc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvBanbe;
    ArrayList<Banbe> arrBanbe;
    BanbeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new BanbeAdapter(this,R.layout.dong_banbe,arrBanbe);
        lvBanbe.setAdapter(adapter);
    }

    private void AnhXa(){
        lvBanbe = (ListView) findViewById(R.id.listviewFriend);
        arrBanbe = new ArrayList<>();

        arrBanbe.add(new Banbe(R.drawable.img_2,"THQuan","Nam","20"));
        arrBanbe.add(new Banbe(R.drawable.img_1,"TVChinh","Nam","20"));
        arrBanbe.add(new Banbe(R.drawable.img_3,"TTDat","Nam","20"));
    }
}