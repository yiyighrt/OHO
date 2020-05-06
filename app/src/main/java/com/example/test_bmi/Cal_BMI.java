package com.example.test_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cal_BMI extends AppCompatActivity {

    private TextView tv_name;
    private ImageView iv_pic;
    private TextView tv_msg;
    private String height;
    private String weight;
    private double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal__bmi);

        findViews();

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        height = bundle.getString("height");
        weight = bundle.getString("weight");

        double h = Double.parseDouble(height) /100.0;
        double w = Double.parseDouble(weight);

        DecimalFormat df = new DecimalFormat("#.##");
        bmi = w / (h *h);

        String msg = "";
        if(bmi <18.5) {
            msg = "過輕";
        } else if (bmi > 24) {
            msg = "過重";
        } else {
            msg = "標準";
        }
        tv_name.setText(name);
        tv_msg.setText("你的BMI是"+df.format(bmi) +","+msg);
    }

    private void findViews() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
    }

    public void addlist(View view) {
        Bundle bundle = new Bundle();

        bundle.putString("height",height);
        bundle.putString("weight",weight);
        bundle.putString("bmi", String.valueOf(bmi));
        Intent intent = new Intent(this, BMI_List.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
