package com.mohsin.canvaspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    customView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_color);
        customView=findViewById(R.id.custom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               customView.colorchange();

            }
        });


    }
}