package com.example.test_bmi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BMI_List extends AppCompatActivity {

    private RecyclerView bmi_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__list);

        Bundle bundle = getIntent().getExtras();

        String h = bundle.getString("height");
        String w = bundle.getString("weight");
        String bmi = bundle.getString("bmi");
        item_list a = new item_list();
        a.setBmi(bmi);
        a.setHeight(h);
        a.setWeight(w);


        ArrayList<item_list> list = new ArrayList<>();

        list.add(a);
        list.add(a);
        list.add(a);
        Log.d("aa",String.valueOf(list.size()));
        bmi_list = findViewById(R.id.bmi_list);
        BMIAdapter adapter = new BMIAdapter(list);
        bmi_list.setAdapter(adapter);
        bmi_list.setLayoutManager(new LinearLayoutManager(this));




    }
}
