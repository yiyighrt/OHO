package com.example.test_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText height;
    private EditText weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void nextPage(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name",name.getText().toString());
        bundle.putString("height",height.getText().toString());
        bundle.putString("weight",weight.getText().toString());
        Intent intent = new Intent(this, Cal_BMI.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void findViews() {
        name= (EditText) findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
    }
}
